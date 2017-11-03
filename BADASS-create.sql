create database BADASS;
use BADASS;

drop table users;
drop table locations;
drop table medical;

create table users(id integer primary key, username varchar(40), password varchar(40));
create table locations(id integer primary key, location_roughlat float, location_roughlong float, location_latitude float, location_longitude float);

create table medical(id integer primary key, medical_flag boolean, medical_urgency integer);

/* medical_flag indicates user has particular medical needs that might not be met in an emergency */
/* medical_urgency indicates how severe the consequences of losing access to prescriptions/treatments would be for the individual */
/* medical_urgency ranges from 0 (least urgent) to 4 (most urgent) */