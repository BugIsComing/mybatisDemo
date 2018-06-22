drop table phone_user;

create table phone_user (
  user_id integer ,
  name varchar(20),
  PRIMARY KEY (user_id)
);
INSERT INTO `phone_user` VALUES (1, 'LC');
INSERT INTO `phone_user` VALUES (2, 'LCLC');

drop table phone;
create table phone (
  phone_id integer ,
  phone_number varchar(20),
  user_id integer,
  PRIMARY KEY (phone_id)
);

INSERT INTO `phone` VALUES (1, '1234', 1);
INSERT INTO `phone` VALUES (2, '12345', 2);
INSERT INTO `phone` VALUES (3, '9875', 1);
INSERT INTO `phone` VALUES (4, '34345', 2);
