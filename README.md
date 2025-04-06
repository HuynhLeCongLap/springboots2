CREATE DATABASE demo; USE demo;

CREATE TABLE users ( id INT AUTO_INCREMENT PRIMARY KEY, username VARCHAR(50) NOT NULL UNIQUE, password VARCHAR(255) NOT NULL, role ENUM('user', 'admin') NOT NULL, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP );

CREATE TABLE posts ( id INT AUTO_INCREMENT PRIMARY KEY, title VARCHAR(255) NOT NULL, body TEXT NOT NULL, user_id INT NOT NULL, status ENUM('draft', 'published') NOT NULL, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE );

CREATE TABLE follows ( following_user_id INT NOT NULL, followed_user_id INT NOT NULL, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, PRIMARY KEY (following_user_id, followed_user_id), FOREIGN KEY (following_user_id) REFERENCES users(id) ON DELETE RESTRICT, FOREIGN KEY (followed_user_id) REFERENCES users(id) ON DELETE RESTRICT );



INSERT INTO users (username, password, role) VALUES ('admin', '$2a$10$ChE3oJpHvdHmZWJ.vU4o3e4irXnM.GPb1SQIFd9ONqGizLqBlo3bK', 'ADMIN');
