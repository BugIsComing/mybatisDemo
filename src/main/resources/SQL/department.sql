--设置部门上下级关系
drop table department;
create table department(
id integer,
name varchar(30),
pid varchar(20),
PRIMARY key (id)
);

insert into department(id,name,pid)VALUES (1,'lclc','');
insert into department(id,name,pid)VALUES (2,'lclc','1');
insert into department(id,name,pid)VALUES (3,'lclc','1');
insert into department(id,name,pid)VALUES (4,'lclc','2');
insert into department(id,name,pid)VALUES (5,'lclc','3');
