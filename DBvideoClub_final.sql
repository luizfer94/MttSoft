use test;
drop table clientes;
create database video;
use video;
create table videos(
id_video int not null auto_increment,
nombre_video varchar(40) not null,
precio int not null,
tipo enum('Infantil','Adolecentes','Adultos') not null,
primary key(id_video)
);

create table clientes(
id_cliente int not null auto_increment,
nombre_cl varchar(25) not null,
tipo_membresia enum('Normal','Gold') not null,
primary key(id_cliente)
);

create table rentas(
id_renta int not null auto_increment,
id_cliente int not null,
id_video int not null,
costxrent int not null,
fecha date default null,
primary key (id_renta)
);

Alter table rentas add foreign key(id_cliente) references clientes(id_cliente);
alter table rentas add foreign key(id_video) references videos(id_video);

insert into clientes (nombre_cl,tipo_membresia) values ('Sandford Pines', 'Normal');
insert into clientes (nombre_cl,tipo_membresia) values ('Stanley Pines', 'Gold');
insert into clientes (nombre_cl,tipo_membresia) values ('Luis Sapiens', 'Normal');
insert into clientes (nombre_cl,tipo_membresia) values ('Alfonso Torres', 'Gold');

insert into videos(nombre_video,precio,tipo) values ('El hombre del Saco',50,'Adultos');
insert into videos(nombre_video,precio,tipo) values ('Gladiador',50,'Adultos');
insert into videos(nombre_video,precio,tipo) values ('Efecto Mariposa',35,'Adolecentes' );
insert into videos(nombre_video,precio,tipo) values ('Anabelle',35,'Adolecentes' );
insert into videos(nombre_video,precio,tipo) values ('Cars',25,'Infantil');
insert into videos(nombre_video,precio,tipo) values ('Era del hielo',25,'Infantil');

insert into rentas(id_cliente,id_video,costxrent,fecha) values (1,1,50,NOW());
insert into rentas(id_cliente,id_video,costxrent,fecha) values (1,4,35,NOW());
insert into rentas(id_cliente,id_video,costxrent,fecha) values (2,6,25,NOW());
insert into rentas(id_cliente,id_video,costxrent,fecha) values (2,3,35,NOW());
insert into rentas(id_cliente,id_video,costxrent,fecha) values (3,5,25,NOW());
insert into rentas(id_cliente,id_video,costxrent,fecha) values (3,2,50,NOW());

select * from clientes;
select * from videos;
use video;
select * from rentas;
Select precio from videos where id_video like 5;
-- Total por Cliente
Select c.id_cliente AS ID,c.nombre_cl AS Nombre,r.fecha AS Fecha,sum(r.costxrent) AS Total
from rentas r 
inner join clientes c on r.id_cliente=c.id_cliente
inner join videos v on r.id_video=v.id_video
where c.id_cliente = 1 AND r.fecha= NOW();
-- Total por membresia
Select c.tipo_membresia AS Membresia,r.fecha AS Fecha,sum(r.costxrent) AS Total
from rentas r 
inner join clientes c on r.id_cliente=c.id_cliente
inner join videos v on r.id_video=v.id_video
group by c.tipo_membresia;
-- Total por tipo
Select v.tipo AS Tipo,r.fecha AS Fecha,sum(r.costxrent) AS Total
from rentas r 
inner join clientes c on r.id_cliente=c.id_cliente
inner join videos v on r.id_video=v.id_video
where r.fecha = "2016-12-18"
group by v.tipo;

Delete from rentas where id_cliente=1;