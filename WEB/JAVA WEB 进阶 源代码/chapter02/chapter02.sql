/*创建一个chapter02的数据库，并在该数据库中创建名称为account的表，
  向表中插入若干条数据，具体的SQL语句如下所示*/
CREATE DATABASE chapter02;
USE chapter02;
CREATE TABLE account(
	id int primary key auto_increment,
	name varchar(40),
	money float
)character set utf8 collate utf8_general_ci;

INSERT INTO account(name,money) VALUES('aaa',1000);
INSERT INTO account(name,money) VALUES ('bbb',1000);
INSERT INTO account(name,money) VALUES ('ccc',1000);


/*使用SELECT语句查询account表中的数据，SQL语句如下所示*/
SELECT * FROM account;