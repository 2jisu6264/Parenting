/*데이터 정의어*/
/*
create database mydb default character set utf8;

GRANT ALL PRIVILEGES ON *.* TO 'root'@'localhost' identified by 'rootpw'
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' identified by 'rootpw'
*//*hyerin: 오류 생겨서 주석처리함.*/

create table mydb.member (
    memberid varchar(50) primary key,
    name varchar(50) not null,
    password varchar(10) not null,
    regdate datetime not null
) engine=InnoDB default character set = utf8;
/*깨알: engine=5.5 부터는 기본 엔진이 InnoDB 니까 안써줘도 된다고 함.*/

create table mydb.article (
    article_no int auto_increment primary key,
    writer_id varchar(50) not null,
    writer_name varchar(50) not null,
    title varchar(255) not null,
    regdate datetime not null,
    moddate datetime not null,
    read_cnt int
) engine=InnoDB default character set = utf8;

create table mydb.article_content (
    article_no int primary key,
    content text
) engine=InnoDB default character set = utf8;

create table mydb.reply (
	reply_no int auto_increment primary key,
    article_no int,
	writer_id varchar(50) not null,
	writer_name varchar(50) not null,
    content text,
    regdate datetime not null,
    moddate datetime not null,
    read_cnt int	
) engine=InnoDB default character set = utf8;
