create table if not exists skill(
 skill_id serial primary key not null,
 skill_description varchar(20) not null,
 status varchar(20)
);