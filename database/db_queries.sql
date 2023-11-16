DROP DATABASE IF EXISTS project;

CREATE DATABASE project;

USE project;

CREATE TABLE subjects
(
    id INT(15) PRIMARY KEY AUTO_INCREMENT,
    subName VARCHAR(30),
    code VARCHAR(30),
    hours INT(15),
    sem VARCHAR(30)
);



CREATE TABLE ta
(
    ttaid INT(15) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30),
    taid VARCHAR(30),
    subName VARCHAR(30)

);

CREATE TABLE lsubjects
(
    tlsid INT(15) PRIMARY KEY AUTO_INCREMENT,
    lsName VARCHAR(30),
    lsSem VARCHAR(30)
);

CREATE TABLE students
(
    tsid INT(15) PRIMARY KEY AUTO_INCREMENT,
    stuName VARCHAR(30),
    sReg VARCHAR(30)
);

CREATE TABLE lecturers
(
    tlid INT(15) PRIMARY KEY AUTO_INCREMENT,
    lname VARCHAR(30),
    lid VARCHAR(30),
    sName VARCHAR(30)
);

CREATE TABLE sSubjects
(
    tsSubId INT(15) PRIMARY KEY AUTO_INCREMENT,
    sSubName VARCHAR(30),
    sSubReg VARCHAR(30)
);

CREATE TABLE LD
(
    tldID INT(15) PRIMARY KEY AUTO_INCREMENT,
    ldID VARCHAR(30),
    ldSub VARCHAR(30),
    ldS INT(15),
    ldTW INT(15),
    ldTen INT(15),
    ldFinal INT(15)
);

CREATE TABLE SD
(
    tsdID INT(15) PRIMARY KEY AUTO_INCREMENT,
    sdID VARCHAR(30),
    sdSub VARCHAR(30),
    sdS INT(15),
    sdTW INT(15)
);



