CREATE DATABASE ml_weather;
USE ml_weather;
CREATE TABLE Weather (
    ID int NOT NULL AUTO_INCREMENT,
    WeatherValue varchar(255) NOT NULL,
    DayValue int,
    PRIMARY KEY (ID)
);
