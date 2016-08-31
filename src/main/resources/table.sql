drop table users;
drop table authorities;

create table users (
	username varchar(50) not null primary key,
    password varchar(100) not null,
    enabled boolean not null
) engine=InnoDB character set = utf8;

create table authorities (
	username varchar(50) not null,
    authority varchar(50) not null
) engine=InnoDB character set = utf8;

create unique index ix_auth_username on authorities (username,authority);

insert into users values ('admin', '123', true);
insert into users values ('manager', '123', true);
insert into users values ('user', '123', true);

insert into authorities values ('admin', 'ADMIN');
insert into authorities values ('admin', 'MANAGER');
insert into authorities values ('manager', 'MANAGER');
insert into authorities values ('user', 'USER');