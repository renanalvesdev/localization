create table tb_city (
	id_city bigint not null primary key ,
	name varchar(50) not null,
	qtd_habitants bigint
);

insert into tb_city
(id_city, name, qtd_habitants)
values 
	(1, 'Lisbon', 500000),
	(2, 'Porto', 214000);
	
