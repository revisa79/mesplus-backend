package io.paradigm.mesplusbackend;

import io.paradigm.mesplusbackend.filters.JwtRequestFilter;
import io.paradigm.mesplusbackend.services.MyUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

@EnableWebSecurity
@Slf4j
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailsService myUserDetailService;
    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    //@Value("${VITE_APP_HELLO_URL:http://localhost:8080}") // Inject the environment variable
    //private String viteAppHelloUrl;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and() /// To add CorsConfigurationSource below
                .csrf().disable()
                .authorizeRequests()
                    .mvcMatchers("/admin").hasRole("ADMIN")
                    .antMatchers("/authenticate",
                            "/","/assets/**","/ws/**","/topic/**"
                            ,"/app/**","/vite.svg","/actuator/**").permitAll()
                        /// Need to create an endpoint /inventory
                        // I think you have don't need to do authorization with regards to VIEW such as html, routing, Outlet,
                        // Use authorization only on REST or getting data from backend.
                    .anyRequest().authenticated()
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        /// Set CORS for using VS Code for front-end during development
        CorsConfiguration configuration = new CorsConfiguration();
        //configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
        /// Always allow localhost for development
        List<String> allowedOrigins = new ArrayList<>(Arrays.asList("http://localhost:5173"));

        /// Step 1: Add the server IP dynamically from the environment variable
        String serverIp = System.getenv("VITE_APP_HELLO_URL");
        log.trace("ServerIP : " + serverIp);

        if (serverIp != null && !serverIp.isEmpty()) {
            allowedOrigins.add("http://" + serverIp); // Assuming HTTP, adjust if needed
        }
        configuration.setAllowedOrigins(allowedOrigins);

        //configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
        //configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
