CREATE SEQUENCE user_seq START WITH 1 INCREMENT by 1;

CREATE TABLE user_app (
    id INTEGER PRIMARY KEY NOT NULL,
    name VARCHAR(30) NOT NULL,
    email VARCHAR(30) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

INSERT INTO user_app (id, name, email, created_at) VALUES (nextval('USER_SEQ'),'John 2 Doe', 'johndoe@example.com', '2023-05-27 04:34:12');
INSERT INTO user_app (id, name, email, created_at) VALUES (nextval('USER_SEQ'),'Jane Smith', 'janesmith@example.com', '2023-05-27 04:34:12');
INSERT INTO user_app (id, name, email, created_at) VALUES (nextval('USER_SEQ'),'Peter Jones', 'peterjones@example.com', '2023-09-08 00:47:38');
INSERT INTO user_app (id, name, email, created_at) VALUES (nextval('USER_SEQ'),'Mary Brown', 'marybrown@example.com', '2023-06-10 23:37:22');
INSERT INTO user_app (id, name, email) VALUES (nextval('USER_SEQ'),'Robert Thompson', 'robertthompson@example.com');

COMMIT;