create database Tienda3;
drop table medida;
use Tienda3;

/* CREANDO LA TABLA DE UNIDADES DE MEDIDA */
CREATE TABLE medida
( idMedida int Primary Key NOT NULL,
 descripcion varchar(50) NOT NULL,
 siglas varchar(3)
)
insert into medida(idMedida, descripcion, siglas) values
(2,"Litros","l"),
(3,"Miliitros","ml"),
(4,"Milimetros","mm");
select * from medida;
describe medida;
insert into documento(idDocumento, descripcion, siglas) values
(1,"Boleta","l"),
(2,"","ml"),
(3,"Milimetros","mm");
select * from medida;
describe medida;
/* CREANDO LA TABLA DE DOCUMENTOS CONTABLES */
CREATE TABLE documento
( idDocumento int Primary Key NOT NULL,
 descripcion varchar(30) NOT NULL,
 siglas varchar(3)
)
/* CREANDO LA TABLA DE CLIENTES */
CREATE TABLE cliente
( idCliente int Primary Key NOT NULL,
 razonSocial varchar(50) NOT NULL,
tipoPersona varchar(01) NOT NULL CHECK (tipoPersona IN ('J','N')) ,
 nrodocumento varchar(11) NOT NULL,
 direccion varchar(50),
 telefono varchar(9)
)
/* CREANDO LA TABLA DE ARTICULOS */
CREATE TABLE articulo
( idArticulo int Primary Key NOT NULL,
 descripcion varchar(50) NOT NULL,
 descripcionIngles varchar(50),
 idUnidadMedidaCompra int,
idUnidadMedidaVenta int,
 cantidadUnidadMedidaCompra int,
 precioVentaMayor decimal(6,2),
 precioVentaMenor decimal(6,2),
 precioCompra decimal(6,2),
 stock decimal(6,2),
 constraint articulo_mefk1 Foreign Key (idUnidadMedidaCompra)
 references medida (idMedida)
 on delete NO ACTION
 on update NO ACTION,
 constraint articulo_mefk2 Foreign Key (idUnidadMedidaVenta)
 references medida (idMedida)
 on delete NO ACTION
 on update NO ACTION
)
/* CREANDO LA TABLA DE VENTAS */
CREATE TABLE venta (
 idVenta int Primary Key NOT NULL,
 idDocumento int NOT NULL,
 serieDocumento varchar(03) NOT NULL,
 nroDocumento varchar(06) NOT NULL,
 fecha date NOT NULL,
 idCliente int NOT NULL,
 constraint venta_clfk1 Foreign Key (idCliente)
 references cliente (idCliente)
on delete NO ACTION
 on update NO ACTION,
 constraint venta_dofk2 Foreign Key (idDocumento)
 references documento (idDocumento)
on delete NO ACTION
 on update NO ACTION
)
/* CREANDO LA TABLA DE DETALLE DE LAS VENTAS */
CREATE TABLE ventaDetalle (
 idVentaDetalle int Primary Key NOT NULL,
 idVenta int NOT NULL,
 idArticulo int NOT NULL,
 cantidad decimal(6,2) NOT NULL,
  constraint ventaDetalle_vtfk1 Foreign Key (idVenta)
 references venta (idVenta)
 on delete NO ACTION
 on update NO ACTION,
 constraint ventaDetalle_arfk2 Foreign Key (idArticulo)
 references articulo (idArticulo)
 on delete NO ACTION
 on update NO ACTION
)
CREATE TABLE proveedor
( idProveedor int Primary Key NOT NULL,
 razonSocial varchar(50) NOT NULL,
 tipoPersona varchar(01) NOT NULL CHECK (tipoPersona IN ('J','N')) ,
 nrodocumento varchar(11) NOT NULL,
 direccion varchar(50),
 telefono varchar(9)
)
select *from medida;
CREATE TABLE compra (
 idCompra int Primary Key NOT NULL,
 idDocumento int NOT NULL,
 serieDocumento varchar(03) NOT NULL,
 nroDocumento varchar(06) NOT NULL,
 fecha date NOT NULL,
 idProveedor int NOT NULL,
 constraint compra_clfk1 Foreign Key (idProveedor)
 references proveedor (idProveedor)
on delete NO ACTION
 on update NO ACTION,
 constraint compra_dofk2 Foreign Key (idDocumento)
 references documento (idDocumento)
on delete NO ACTION
 on update NO ACTION
)
CREATE TABLE compraDetalle (
 idCompraDetalle int Primary Key NOT NULL,
 idCompra int NOT NULL,
 idArticulo int NOT NULL,
 cantidad decimal(6,2) NOT NULL,
 constraint compraDetalle_vtfk1 Foreign Key (idCompra)
 references compra (idCompra)
 on delete NO ACTION
 on update NO ACTION,
 constraint compraDetalle_arfk2 Foreign Key (idArticulo)
 references articulo (idArticulo)
 on delete NO ACTION
 on update NO ACTION
)
select a.idArticulo, a.descripcion, a.descripcionIngles , a.idUnidadMedidaCompra  , a.idUnidadMedidaVenta  , a.cantidadUnidadMedidaCompra , a.precioVentaMayor , a.precioVentaMenor , a.precioCompra , a.stock  from articulo a, medida m, medida m2 where a.idUnidadMedidaCompra = m.idMedida and a.idUnidadMedidaVenta = m2.idMedida;

show triggers from Tienda3;


CREATE TRIGGER actualizarStockcompra
AFTER insert ON compraDetalle
FOR EACH ROW

	update articulo set articulo.stock = articulo.stock + new.cantidad where idArticulo = new.idArticulo ;

    
insert into compraDetalle values (10,1,1,10);
delete from compraDetalle where idcompraDetalle= 2;
CREATE TRIGGER actualizarStockventa
AFTER insert ON ventaDetalle
FOR EACH ROW
	update articulo Set articulo.stock = articulo.stock-new.cantidad where articulo.idArticulo = new.idArticulo ;
    
drop TRIGGER actualizarStock;
select * from articulo;