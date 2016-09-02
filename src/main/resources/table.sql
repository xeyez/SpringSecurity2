drop table t_user;

create table t_user (
  userid varchar(100) not null,
  userpw varchar(100) not null,
  username varchar(100) not null,
  role varchar(50) default 'USER',
  primary key (userid)
);

desc t_user;