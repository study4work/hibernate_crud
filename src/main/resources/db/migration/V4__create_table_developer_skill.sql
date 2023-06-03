create table if not exists developer_skill(
 developer_id int,
 skill_id int,
 foreign key (developer_id) references developer(developer_id),
 foreign key (skill_id) references skill(skill_id)
);