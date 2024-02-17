CREATE TABLE IF NOT EXISTS users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_name VARCHAR(255) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  active BOOLEAN DEFAULT TRUE,
  roles VARCHAR(255) NOT NULL DEFAULT ''
);

  INSERT INTO users (user_name, password, active, roles)
  SELECT 'user', 'pass', FALSE, "ROLE_ADMIN"
  WHERE NOT EXISTS (
      SELECT 1 FROM users WHERE user_name = 'user'
  );

  INSERT INTO users (user_name, password, active, roles)
    SELECT 'manager', 'pass', FALSE, "ROLE_ADMIN"
    WHERE NOT EXISTS (
        SELECT 1 FROM users WHERE user_name = 'manager'
    );


