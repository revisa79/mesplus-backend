-- init.sql
CREATE DATABASE IF NOT EXISTS mydatabase;
USE mydatabase;
SOURCE /docker-entrypoint-initdb.d/backup.sql;
