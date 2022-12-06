create database delhi_metro;
use delhi_metro;
create user if not exists 'delhimetro'@'localhost' identified by '1234';
grant all on *.* to 'delhimetro'@'localhost';
create table if not exists stations(
    id bigint primary key auto_increment,
    station_id int unique,
    station_name varchar(255),
    station_code varchar(10) unique
);

select * from stations;

create table if not exists station_info(
	id bigint primary key ,
	foreign key(id) references stations(id),
	interchange boolean,
    latitude double,
    longitude double,
    mobile varchar(100),
	landline varchar(100),
    station_type varchar(100),
    x_coords double,
    y_coords double
);
select * from station_info;
delete  from station_info;
ALTER TABLE station_info
add foreign key(id) references stations(id);
drop table station_info;


create table metro_lines(
	id bigint primary key auto_increment,
	line_id integer unique,
    name varchar(100),
    status varchar(50),
    line_color varchar(50),
    line_code varchar(20),
    primary_color_code varchar(100),
    secondary_color_code varchar(100),
    class_primary varchar(50),
    class_secondary varchar(50),
    start_station bigint,
    foreign key(start_station) references stations(id),
    end_station bigint,
    foreign key(end_station) references stations(id)
);
select * from metro_lines;
delete from metro_lines;
-- drop table metro_lines; 
create table metro_gates(
	id bigint primary key auto_increment,
	location varchar(255),
    status varchar(50),
    gate_name varchar(50),
	gate_code varchar(20),
	gate_latitude double,
    gate_longitude double,
    divyang_friendly boolean,
    station_id bigint,
    foreign key(station_id) references stations(id)
);
select * from metro_gates;
delete from metro_gates;
create table platforms(
	id bigint primary key auto_increment,
	platform_names varchar(255),
    train_towards bigint,
    foreign key(train_towards) references stations(id),
    train_towards_second bigint,
    foreign key(train_towards_second) references stations(id),
    platform_code varchar(20),
    station_id bigint,
    foreign key(station_id) references stations(id)
);
select * from platforms;
delete from platforms;
drop table platforms;

create table station_facilities(
	id bigint primary key auto_increment,
    station_id bigint,
    foreign key(station_id) references stations(id),
    facility_id bigint,
    foreign key(facility_id) references facilities(id)
);
select * from station_facilities;
delete from station_facilities;
create table facilities(
	id bigint primary key auto_increment,
    kind varchar(100) unique,
    image varchar(255)
);
select * from facilities;
delete from facilities;
create table prev_next_stations(
	id bigint primary key auto_increment,
    line_id bigint,
    foreign key(line_id) references metro_lines(line_id),
    prev_station bigint,
    foreign key(prev_station) references station_info(id),
    next_station bigint,
    foreign key(next_station) references station_info(id),
	station_id bigint,
    foreign key(station_id) references station_info(id)
);
