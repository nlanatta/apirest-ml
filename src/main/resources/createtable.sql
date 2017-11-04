CREATE DATABASE ml_weather;
USE ml_weather;
CREATE TABLE weather (
    ID int NOT NULL AUTO_INCREMENT,
    weather_value varchar(255) NOT NULL,
    day_value int,
    PRIMARY KEY (ID)
);
CREATE TABLE weather_count_result (
    ID int NOT NULL AUTO_INCREMENT,
    weather_type varchar(255) NOT NULL,
    weather_value varchar(255) NOT NULL,
    day_count_value int,
    PRIMARY KEY (ID)
);


/////////PROD//////////////////
CREATE DATABASE ebdb;
USE ebdb;
CREATE TABLE weather (
    ID int NOT NULL AUTO_INCREMENT,
    weather_value varchar(255) NOT NULL,
    day_value int,
    PRIMARY KEY (ID)
);
CREATE TABLE weather_count_result (
    ID int NOT NULL AUTO_INCREMENT,
    weather_type varchar(255) NOT NULL,
    weather_value varchar(255) NOT NULL,
    day_count_value int,
    PRIMARY KEY (ID)
);