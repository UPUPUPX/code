/*创建chapter03数据库，然后在数据库中创建一个表user，具体语句如下*/
CREATE DATABASE chapter03;
USE chapter03;
CREATE TABLE user(
id INT(3) PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(20) NOT NULL,
password VARCHAR(20) NOT NULL
);


/*向user表插入三条数据，具体语句如下*/
INSERT INTO user(name,password)  VALUES('zhangsan','123456');
INSERT INTO user(name,password)  VALUES ('lisi','123456');
INSERT INTO user(name,password)  VALUES ('wangwu','123456');


/*使用SELECT语句查询users表，SQL语句如下所示*/
SELECT * FROM user;
