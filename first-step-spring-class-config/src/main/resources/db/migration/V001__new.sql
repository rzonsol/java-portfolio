create table USER (
    ID int  NOT NULL AUTO_INCREMENT,
    LOGIN  varchar(100) not null,
    EMAIL  varchar(100) not null,
    FIRST_NAME  varchar(100) not null,
    LAST_NAME  varchar(100) not null,
    PRIMARY KEY (ID)
);
create table ROLES (
    ROLE_ID int NOT NULL AUTO_INCREMENT,
    ROLE_NAME  varchar(100) not null,
    USER_ID int,
    IDX INT default NULL,
    CONSTRAINT FK_USER_ID FOREIGN KEY (USER_ID) REFERENCES USER(ID),
    PRIMARY KEY (ROLE_ID)
);
create table USER_ROLES (
	ID int NOT NULL AUTO_INCREMENT,
    USER_ID int,
    ROLE_ID int,
	FOREIGN KEY (USER_ID) REFERENCES USER(ID),
	FOREIGN KEY (ROLE_ID) REFERENCES ROLES(ROLE_ID),
	PRIMARY KEY (ID)
);
create table MESSAGES (
    ID int NOT NULL AUTO_INCREMENT,
    USER_ID int,
    FOREIGN KEY (USER_ID) REFERENCES USER(ID),
    TITLE  varchar(200),
    CONTENT  varchar(200),
    PRIMARY KEY (ID)
);


insert into USER ( LOGIN, EMAIL, FIRST_NAME, LAST_NAME) values ('LOGIN1','EMAIL1','NAME1','LASTNAME1');
insert into USER ( LOGIN, EMAIL, FIRST_NAME, LAST_NAME) values ('LOGIN2','EMAIL2','NAME2','LASTNAME2');
insert into USER ( LOGIN, EMAIL, FIRST_NAME, LAST_NAME) values ('LOGIN3','EMAIL3','NAME3','LASTNAME3');
insert into USER ( LOGIN, EMAIL, FIRST_NAME, LAST_NAME) values ('LOGIN4','EMAIL4','NAME4','LASTNAME4');
insert into USER ( LOGIN, EMAIL, FIRST_NAME, LAST_NAME) values ('LOGIN5','EMAIL5','NAME5','LASTNAME5');

