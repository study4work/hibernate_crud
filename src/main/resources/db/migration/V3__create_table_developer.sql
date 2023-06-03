Create table if not exists developer(
 developer_id serial primary key not null,
 specialty_id int references specialty(specialty_id),
 first_name varchar(20) not null,
 last_name varchar(20) not null,
 status varchar(20)
);