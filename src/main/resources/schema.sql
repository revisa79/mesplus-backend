

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

  INSERT INTO users (user_name, password, active, roles)
      SELECT 'ShelbyT', 'pass', FALSE, "ROLE_ADMIN"
      WHERE NOT EXISTS (
          SELECT 1 FROM users WHERE user_name = 'ShelbyT'
      );

-- Schema for the FloorBoardModel entity with safeguards
CREATE TABLE IF NOT EXISTS floorboard (
    id BIGINT AUTO_INCREMENT PRIMARY KEY, -- Auto-generated primary key
    job_id VARCHAR(255) NOT NULL,         -- Job ID (non-nullable)
    type VARCHAR(255),                    -- Type of floorboard (nullable)
    machine_id VARCHAR(255),              -- Machine ID (nullable)
    time_created DATETIME NOT NULL,       -- Timestamp when the entry was created (non-nullable)
    author VARCHAR(255),                  -- Author of the entry (nullable)
    priority_level INT DEFAULT 0          -- Priority level (defaults to 0 if not specified)
);


-- Call the procedure for each index
--CALL DropAndRecreateIndex('idx_job_id', 'floorboard', 'job_id');
--CALL DropAndRecreateIndex('idx_machine_id', 'floorboard', 'machine_id');
--CALL DropAndRecreateIndex('idx_priority_level', 'floorboard', 'priority_level');

-- Insert initial records into the floorboard table

INSERT INTO floorboard (job_id, type, priority_level, machine_id, time_created, author)
SELECT 'JOB-A1234','A', 1, 'MACHINE003', '2024-07-14 11:48:30', 'EscalanteJ'
WHERE NOT EXISTS (
    SELECT 1 FROM floorboard WHERE job_id = 'JOB-A1234'
);

INSERT INTO floorboard (job_id, type, priority_level, machine_id, time_created, author)
SELECT 'JOB-A5678','A', 1, 'MACHINE001', DATE_SUB(NOW(), INTERVAL 1 HOUR), 'VaronaD'
WHERE NOT EXISTS (
    SELECT 1 FROM floorboard WHERE job_id = 'JOB-A5678'
);

INSERT INTO floorboard (job_id, type, priority_level, machine_id, time_created, author)
SELECT 'JOB-I0008','I', 1, 'MACHINE001', DATE_SUB(NOW(), INTERVAL 1 DAY), 'ZeinaB'
WHERE NOT EXISTS (
    SELECT 1 FROM floorboard WHERE job_id = 'JOB-I0008'
);

INSERT INTO floorboard (job_id, type, priority_level, machine_id, time_created, author)
SELECT 'JOB-A9101','A', 100, 'MACHINE001', DATE_SUB(NOW(), INTERVAL 2 DAY), 'RevisA'
WHERE NOT EXISTS (
    SELECT 1 FROM floorboard WHERE job_id = 'JOB-A9101'
);

INSERT INTO floorboard (job_id, type, priority_level, machine_id, time_created, author)
SELECT 'JOB-H1011','H', 2, 'MACHINE001', DATE_SUB(NOW(), INTERVAL 30 DAY), 'ShelbyT'
WHERE NOT EXISTS (
    SELECT 1 FROM floorboard WHERE job_id = 'JOB-H1011'
);


