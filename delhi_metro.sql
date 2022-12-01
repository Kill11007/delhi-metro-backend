create database delhi_metro;
use delhi_metro;
create user if not exists 'delhimetro'@'localhost' identified by '1234';
grant all on *.* to 'delhimetro'@'localhost';
create table if not exists stations(
    id bigint primary key auto_increment,
    
    station_id int unique,
    station_name varchar(255) ,
    station_code varchar(10) unique
);

select * from stations;