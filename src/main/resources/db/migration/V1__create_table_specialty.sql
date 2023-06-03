create table if not exists specialty(
  specialty_id serial primary key not null ,
  specialty_description varchar(20),
  status varchar(20)
);