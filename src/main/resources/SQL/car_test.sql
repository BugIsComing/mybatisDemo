--car_test表格，用于试验mybatis关联查询中一对一的多表结构
drop table car_test;

create table car_test (
  carid integer ,
  cartype varchar(20),
  engineid integer,
  brakeid integer,
  PRIMARY KEY (carid)
);

insert into car_test (carid, cartype, engineid, brakeid) values(1, 'VW', 1,1);
insert into car_test (carid, cartype, engineid, brakeid) values(2, 'Opel',   1,2);
insert into car_test (carid, cartype, engineid, brakeid) values(3, 'Audi', 2,1);
insert into car_test (carid, cartype, engineid, brakeid) values(4, 'Ford', 2,2);

drop table engine_test;

create table engine_test (
  engineid integer ,
  enginetype varchar(20),
  enginecylinders integer,
  PRIMARY KEY (engineid)
);

insert into engine_test (engineid, enginetype, enginecylinders) values(1, 'Diesel', 4);
insert into engine_test (engineid, enginetype, enginecylinders) values(2, 'Gas',8);

drop table brake_test;

create table brake_test (
  brakeid integer ,
  braketype varchar(20),
  PRIMARY KEY (brakeid)
);

insert into brake_test (brakeid, braketype) values(1, 'disk');
insert into brake_test (brakeid, braketype) values(2, 'drum');