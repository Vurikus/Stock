DROP TABLE IF EXISTS users;

CREATE TABLE users (
    user_id SERIAL,
    login varchar (20),
    password varchar (20),
    PRIMARY KEY (user_id)
);