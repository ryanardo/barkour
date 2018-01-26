SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS parks (
    id INT PRIMARY KEY AUTO_INCREMENT,
    park VARCHAR,
    description VARCHAR,
--  FOREIGN KEYS
    locationId INTEGER
);

CREATE TABLE IF NOT EXISTS locations (
    id INT PRIMARY KEY AUTO_INCREMENT,
    location VARCHAR,
    description VARCHAR,
--  FOREIGN KEYS
    eventId INTEGER
);

CREATE TABLE IF NOT EXISTS reviews (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR,
    review VARCHAR,
    rating INTEGER,
--  FOREIGN KEYS
    parkId INTEGER
);