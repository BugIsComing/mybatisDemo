--cars表格，用于试验mybatis关联查询中一对一的关联
drop table cars;  
  
create table cars (  
  carid integer ,
  cartype varchar(20),  
  enginetype varchar(20),  
  enginecylinders integer,  
  brakestype varchar(20),
  PRIMARY KEY (carid)
);  
  
insert into cars (carid, cartype, enginetype, enginecylinders, brakestype) values(1, 'VW',   'Diesel', 4,    null);  
insert into cars (carid, cartype, enginetype, enginecylinders, brakestype) values(2, 'Opel',    null,    null, 'drum');  
insert into cars (carid, cartype, enginetype, enginecylinders, brakestype) values(3, 'Audi', 'Diesel', 4,    'disk');  
insert into cars (carid, cartype, enginetype, enginecylinders, brakestype) values(4, 'Ford', 'Gas',    8,    'drum');  