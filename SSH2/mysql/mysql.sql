create table user(id int primary key auto_increment,
name char(20),
password char(20),
email char(20),
sex char(5),
acSum int);


create table problem(id int primary key auto_increment,
title char(20),
content varchar(255),
testIn char(20),
testOut char(20));

create table result(id int primary key auto_increment,
time char(20),
date char(20),
result char(20),
user_id int references user(id),
priblem_id int references problem(id));