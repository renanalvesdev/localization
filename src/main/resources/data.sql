create table tb_city (
	id_city bigint not null primary key ,
	name varchar(50) not null,
	qtd_habitants bigint
);

insert into tb_city
(id_city, name, qtd_habitants)
values 
	(1, 'Lisbon', 500000),
	(2, 'Porto', 214000),
	(3, 'Braga', 192494),
	(4, 'Aveiro', 80000),
	(5, 'Coimbra', 140796),
	(6, 'Fatima', 12000),
	(7, 'Algarve', 438864),
	(8, 'Viana do Castelo', 85784),
	(9, 'Paorto 1', 85784),
	(10, 'Pborto', 85784),
	(12, 'Pcorto3', 85784)	;
	
