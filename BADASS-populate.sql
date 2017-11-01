drop table users;

create table users(username varchar(40) primary key, password varchar(40), location_gps float, location_latitude float, location_longitude float);

insert into users values('sample__username', 'sample_password', 0, 0, 0);