drop table users;
drop table locations;
drop table medical;

create table users(id integer primary key, username varchar(40), password varchar(40));
create table locations(id integer primary key, location_roughlat float, location_roughlong float, location_latitude float, location_longitude float);

create table medical(id integer primary key, medical_flag boolean, medical_urgency integer);

/* medical_flag indicates user has particular medical needs that might not be met in an emergency */
/* medical_urgency indicates how severe the consequences of losing access to prescriptions/treatments would be for the individual */
/* medical_urgency ranges from 0 (least urgent) to 4 (most urgent) */

insert into users values(1, 'Alice', 'alices_password');
insert into users values(2, 'Bob', 'bobs_password');
insert into users values(3, 'Chris', 'chriss_password');
insert into users values(4, 'Denise', 'denises_password');
insert into users values(5, 'Elaine', 'elaines_password');
insert into users values(6, 'Fred', 'freds_password');
insert into users values(7, 'Gina', 'ginas_password');

insert into locations values(1, 0, 0, 0, 0);
insert into locations values(2, 0, 0, 0, 0);
insert into locations values(3, 0, 0, 0, 0);
insert into locations values(4, 0, 0, 0, 0);
insert into locations values(5, 0, 0, 0, 0);
insert into locations values(6, 0, 0, 0, 0);
insert into locations values(7, 0, 0, 0, 0);

insert into medical values(1, false, 0);
insert into medical values(2, false, 0);
insert into medical values(3, true, 4);
insert into medical values(4, true, 2);
insert into medical values(5, false, 0);
insert into medical values(6, true, 1);
insert into medical values(7, false, 0);

