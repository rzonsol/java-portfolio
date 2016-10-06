create table USERS (
    ID int  NOT NULL AUTO_INCREMENT,
    LOGIN  varchar(100) not null,
    EMAIL  varchar(100) not null,
    FIRST_NAME  varchar(100) not null,
    LAST_NAME  varchar(100) not null,
    PRIMARY KEY (ID)
);
create table ROLES (
    ID int NOT NULL AUTO_INCREMENT,
    NAME  varchar(100) not null,
    PRIMARY KEY (ID)
);
create table USER_ROLES (
	ID int NOT NULL AUTO_INCREMENT,
    USER_ID int,
    ROLE_ID int,
	FOREIGN KEY (USER_ID) REFERENCES USERS(ID),
	FOREIGN KEY (ROLE_ID) REFERENCES ROLES(ID),
	PRIMARY KEY (ID)
);
create table MESSAGES (
    ID int NOT NULL AUTO_INCREMENT,
    USER_ID int,
    FOREIGN KEY (USER_ID) REFERENCES USERS(ID),
    TITLE  varchar(200),
    CONTENT  varchar(200),
    PRIMARY KEY (ID)
);