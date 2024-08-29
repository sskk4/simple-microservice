CREATE TABLE IF NOT EXISTS Image
(
                       id        BIGINT AUTO_INCREMENT PRIMARY KEY,
                       title     VARCHAR(255),
                       file_name  VARCHAR(255),
                       imagedata LONGBLOB,
                       user_id BIGINT UNIQUE,
                       FOREIGN KEY (user_id) REFERENCES user (id)
);
