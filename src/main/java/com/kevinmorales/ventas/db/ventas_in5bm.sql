drop database if exists ventas_in5bm;
create database ventas_in5bm;
use ventas_in5bm;

create table Usuarios(
	codigo_usuario int auto_increment not null primary key,
	username varchar(45) not null unique,
    password varchar(60) not null,
    email varchar(60) not null unique,
    rol varchar(45) not null,
    estado boolean not null default true
);

create table Clientes(
	dpi_cliente bigint not null primary key,
    nombre_cliente varchar(50) not null,
    apellido_cliente varchar(50) not null,
    direccion varchar(100) not null,
    estado boolean not null default true
);

create table Productos(
	codigo_producto int auto_increment not null primary key,
    nombre_producto varchar(60) not null,
    precio decimal(10,2) not null,
    stock int not null,
    estado boolean not null
);

create table Ventas(
	codigo_venta int auto_increment not null primary key,
    fecha_venta date not null,
    total decimal(10,2) not null,
    estado boolean not null,
    Clientes_dpi_cliente bigint not null,
		foreign key (Clientes_dpi_cliente) references Clientes(dpi_cliente)
        on delete cascade,
	Usuarios_codigo_usuario int not null,
		foreign key (Usuarios_codigo_usuario) references Usuarios(codigo_usuario)
        on delete cascade
);

create table DetalleVenta(
	codigo_detalle_venta int auto_increment not null primary key,
    cantidad int not null,
    precio_unitario decimal(10,2) not null,
    subtotal decimal(10,2) not null,
    Productos_codigo_producto int not null,
		foreign key (Productos_codigo_producto) references Productos(codigo_producto)
        on delete cascade,
	Ventas_codigo_venta int not null,
		foreign key (Ventas_codigo_venta) references Ventas(codigo_venta)
        on delete cascade
);

insert into Usuarios(username, password, email, rol)
values ('Admin', '$2a$12$6hEUNrOr4L96zbeDV8WHous3NwldjkYPtfVS2wbjxQCBXyaFSqKLK', 'admin@kinal.edu.gt', 'ADMIN');
-- Contraseña sin hash: 1234
