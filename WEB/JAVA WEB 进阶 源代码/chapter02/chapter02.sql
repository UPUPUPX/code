/*����һ��chapter02�����ݿ⣬���ڸ����ݿ��д�������Ϊaccount�ı�
  ����в������������ݣ������SQL���������ʾ*/
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


/*ʹ��SELECT����ѯaccount���е����ݣ�SQL���������ʾ*/
SELECT * FROM account;