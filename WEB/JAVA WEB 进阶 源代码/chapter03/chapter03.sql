/*����chapter03���ݿ⣬Ȼ�������ݿ��д���һ����user�������������*/
CREATE DATABASE chapter03;
USE chapter03;
CREATE TABLE user(
id INT(3) PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(20) NOT NULL,
password VARCHAR(20) NOT NULL
);


/*��user������������ݣ������������*/
INSERT INTO user(name,password)  VALUES('zhangsan','123456');
INSERT INTO user(name,password)  VALUES ('lisi','123456');
INSERT INTO user(name,password)  VALUES ('wangwu','123456');


/*ʹ��SELECT����ѯusers��SQL���������ʾ*/
SELECT * FROM user;
