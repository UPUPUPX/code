/*��MySQL�д���һ������Ϊchapter01�����ݿ⣬
  Ȼ���ڸ����ݿ��д���һ��users��SQL���������ʾ*/
CREATE DATABASE chapter01;
USE chapter01;
CREATE TABLE users(
		id INT PRIMARY KEY AUTO_INCREMENT,
		name VARCHAR(40),
		password VARCHAR(40),
		email VARCHAR(60),
		birthday DATE 
)CHARACTER SET utf8 COLLATE utf8_general_ci;


/*���ݿ�ͱ����ɹ�������users���в���3�����ݣ�SQL���������ʾ*/
INSERT INTO users(NAME,PASSWORD,email,birthday) 
VALUES('zs','123456','zs@sina.com','1980-12-04');
INSERT INTO users(NAME,PASSWORD,email,birthday) 
VALUES('lisi','123456','lisi@sina.com','1981-12-04');
INSERT INTO users(NAME,PASSWORD,email,birthday) 
VALUES('wangwu','123456','wangwu@sina.com','1979-12-04');


/*Ϊ�˲鿴�����Ƿ���ӳɹ���ʹ��SELECT����ѯusers��SQL���������ʾ*/
SELECT * FROM users;