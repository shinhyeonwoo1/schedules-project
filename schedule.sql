CREATE DATABASE IF NOT EXISTS schedule_db DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE schedule_db;

-- 사용자 테이블
CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       email VARCHAR(100) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 일정 테이블
CREATE TABLE schedules (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           user_id INT NOT NULL,
                           title VARCHAR(100) NOT NULL,
                           description TEXT,
                           start_time DATETIME NOT NULL,
                           end_time DATETIME NOT NULL,
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- 태그 테이블
CREATE TABLE tags (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(30) NOT NULL UNIQUE
);

-- 일정-태그 연결 테이블 (Many-to-Many)
CREATE TABLE schedule_tags (
                               schedule_id INT NOT NULL,
                               tag_id INT NOT NULL,
                               PRIMARY KEY (schedule_id, tag_id),
                               FOREIGN KEY (schedule_id) REFERENCES schedules(id) ON DELETE CASCADE,
                               FOREIGN KEY (tag_id) REFERENCES tags(id) ON DELETE CASCADE
);