
# Use Maven to build the application
FROM maven:3.8.6-openjdk-11-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Use a minimal image to run the application
FROM openjdk:11-jdk-slim
# Create user to run app as (instead of root)
RUN addgroup --system appgroup && adduser --system appuser --ingroup appgroup
# Set working directory
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Expose the port that the application will run on
EXPOSE 8080

# Change ownership of the app directory
RUN chown -R appuser:appgroup /app

# Switch to the non-root user
USER appuser

ENTRYPOINT ["java", "-jar", "app.jar"]

