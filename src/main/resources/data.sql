create table tb_city (
	id_city bigint not null primary key ,
	name varchar(50) not null,
	habitants bigint
);

insert into tb_city
(id_city, name, habitants)
values 
	(1, 'Lisbon', 500000),
	(2, 'Porto', 214000);
	
