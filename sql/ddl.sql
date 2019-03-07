/*µ¥ÀÌÅÍ Á¤ÀÇ¾î*/
/*
create database mydb default character set utf8;

GRANT ALL PRIVILEGES ON *.* TO 'root'@'localhost' identified by 'rootpw'
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' identified by 'rootpw'
*//*hyerin: ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½Ü¼ï¿½ ï¿½Ö¼ï¿½Ã³ï¿½ï¿½ï¿½ï¿½.*/

create table mydb.member (
    memberid varchar(50) primary key,
    name varchar(50) not null,
    password varchar(10) not null,
    regdate datetime not null
) engine=InnoDB default character set = utf8;
/*±ú¾Ë: engine=5.5 ºÎÅÍ´Â ±âº» ¿£ÁøÀÌ InnoDB ´Ï±î ¾È½áÁàµµ µÈ´Ù°í ÇÔ.*/

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

<<<<<<< HEAD
create table mydb.reply (
	reply_no int auto_increment primary key,
    article_no int,
	writer_id varchar(50) not null,
	writer_name varchar(50) not null,
    content text,
    regdate datetime not null,
    moddate datetime not null,
    read_cnt int	
}engine=InnoDB default character set = utf8;
create table mydb.article_file (
    article_no int primary key,
    file varchar(50)
) engine=InnoDB default character set = utf8;
