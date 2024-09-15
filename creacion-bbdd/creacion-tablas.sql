-- Creación de la base de datos
drop database if exists stocky;
create database stocky;

use stocky;

-- Creación de las tablas

-- 1º GESTIÓN DE INVENTARIOS ---------------------------------------------------------------------------------------------------------------------------------------------------------------------

/*
	- Control de stock en tiempo real: Registro de la cantidad de cada producto disponible.
	- Gestión de entradas y salidas de productos: Registro de cuándo y cuántos productos entran y salen.
	- Alertas de niveles bajos de inventario: Notificaciones cuando el inventario está bajo.
	- Gestión de productos perecederos: Registro de fechas de caducidad.student
*/

create table categoria(
	id_categoria int auto_increment,
    nombre varchar(255) not null,
    descripcion text,
    constraint categoria_id_categoria_pk primary key (id_categoria)
);

create table subcategoria(
	id_subcategoria int auto_increment,
    id_categoria int not null,
    nombre varchar(255) not null,
    descripcion text,
    constraint subcategoria_id_subcategoria_pk primary key (id_subcategoria),
    constraint subcategoria_id_categoria_fk foreign key (id_categoria) references categoria (id_categoria) on delete cascade on update cascade
);

create table unidadMedida(
	id_unidad_medida int auto_increment,
    nombre varchar(255) not null,
    descripcion text,
    constraint unidadMedida_id_unidad_medida_pk primary key (id_unidad_medida)
);

create table persona(
	id_persona int auto_increment,
	nombre varchar(255) not null,
    direccion text,
    telefono varchar(20) not null,
    email varchar(255),
    activo boolean default true,
    contacto_principal varchar(255),
    constraint persona_id_persona_pk primary key (id_persona)
);

create table proveedor(/*proveedor pertenece a la sección 2: gestion de compras*/
	id_proveedor int auto_increment,
	id_persona int not null,
    nombre_empresa varchar(255) not null,
    tipo enum("Acreedor", "Proveedor") default "Proveedor" not null,
    constraint proveedor_id_proveedor_pk primary key (id_proveedor),
    constraint proveedor_id_persona_fk foreign key(id_persona) references persona (id_persona)
);

create table producto(
	id_producto int auto_increment,
    id_proveedor int not null,
    nombre varchar(255) not null,
    descripcion text,
    tipo_producto enum('Venta', 'Consumo', 'Servicio') not null,
    id_subcategoria int not null,
    precio_unitario decimal(10,2),
    id_unidad_medida int not null,
    activo boolean default true not null,/*este campo define si el producto está activo o no. Los productos no se pueden eliminar si tienen registros vinculados, se pueden poner en inactivos, indicando que ya no están en venta*/
    fecha_creacion date default current_timestamp not null,
    fecha_actualizacion datetime default current_timestamp on update current_timestamp,
    constraint producto_id_producto_pk primary key (id_producto),
    constraint producto_id_proveedor_fk foreign key (id_proveedor) references proveedor (id_proveedor),
    constraint producto_id_subcategoria_fk foreign key (id_subcategoria) references subcategoria (id_subcategoria) on delete restrict on update cascade,
    constraint producto_id_unidad_medida_fk foreign key (id_unidad_medida) references unidadMedida (id_unidad_medida) on delete restrict on update cascade
);

create table lote(
	id_lote int auto_increment,
    id_proveedor int not null,
    id_producto int not null,
    cantidad_inicial decimal(10,2) not null,/*cantidad inicial de productos contenidos en el lote recibido*/
    cantidad_actual decimal(10,2) not null,
    fecha_entrada date not null,
    fecha_caducidad date,
    precio_compra_unitario decimal(10,2) not null,/*Precio al que se adquirió el producto del proveedor. Unitario, por cada unidad*/
    constraint lote_id_lote_pk primary key (id_lote),
    constraint lote_id_producto_fk foreign key (id_producto) references producto (id_producto),
    constraint lote_id_proveedor_fk foreign key (id_proveedor) references proveedor (id_proveedor)
);

create table ubicacion(
	id_ubicacion int auto_increment,
    nombre varchar(255) not null,
    descripcion text,
    constraint ubicacion_id_ubicacion_pk primary key (id_ubicacion),
    constraint ubicacion_nombre_uq unique (nombre)
);

/*la tabla inventario relaciona una ubicación con un lote. Puede haber varias ubicaciones por lote. En esta tabla se guardan las cantidades por ubicacion y lote*/
create table inventario(
	id_inventario int auto_increment,
    id_lote int not null,
    id_ubicacion int not null,
    cantidad_disponible decimal(10,2) not null,/*este campo hace referencias a cuantas unidades del lote se encuentran en esta ubicación. Puede ser que en dos objetos inventario diferentes haya 40 unidades de un lote y en otro 60 unidades*/
    fecha_entrada date not null,/*fecha de entrada en el inventario, no de compra*/
    fecha_actualizacion timestamp default current_timestamp on update current_timestamp,
    constraint inventario_id_inventario_pk primary key (id_inventario),
    constraint inventario_id_lote_fk foreign key (id_lote) references lote (id_lote) on delete cascade on update cascade,
    constraint inventario_id_ubicacion_fk foreign key (id_ubicacion) references ubicacion (id_ubicacion) on delete restrict on update cascade
);

create table transaccion(
	id_transaccion int auto_increment,
    tipo_transaccion enum('entrada', 'salida') not null,
    cantidad decimal(10,2) not null,/*cantidad de unidades que salen del lote*/
    fecha_transaccion timestamp default current_timestamp not null,
    id_lote int not null,
    descripcion text,
    constraint transaccion_id_transaccion_pk primary key (id_transaccion),
    constraint transaccion_id_lote_fk foreign key (id_lote) references lote (id_lote) on delete restrict on update cascade
);

-- 2º GESTIÓN DE COMPRAS -------------------------------------------------------------------------------------------------------------------------------------------------------------------------

/*
	- Registro y seguimiento de órdenes de compra: Detalles de las órdenes de compra realizadas.
	- Gestión de proveedores y precios: Información de los proveedores y precios de compra.
	- Control de recepciones de mercancía: Registro de la mercancía recibida.
*/

-- El total(precio total) se obtendrá con las vistas haciendo join en la tabla lote
create table ordenCompra (
    id_orden_compra int auto_increment,
    id_proveedor int not null,
    fecha_orden timestamp default current_timestamp not null,-- fecha de creación de la orden
    fecha_estimada_recepcion date not null,
    estado enum('pendiente', 'recibida', 'cancelada') default 'pendiente' not null,
    constraint ordenCompra_id_orden_compra_pk primary key (id_orden_compra),
    constraint ordenCompra_id_proveedor_fk foreign key (id_proveedor) references proveedor (id_proveedor) on delete restrict on update cascade
);

-- El total de cada detalle de compra se obtendrá a través de una vista
create table detalleOrdenCompra (
    id_detalle_orden_compra int auto_increment,
    id_orden_compra int not null,
    id_producto int not null,
    cantidad decimal(10,2) not null,
    -- precio_unitario decimal(10, 2) not null, TOMAREMOS PARA PONER EL PRECIO UNITARIO EL PRECIO MARCADO EN LA TABLA LOTE AL QUE SE COMPRA EL PRODUCTO
    constraint detalleOrdenCompra_id_detalle_orden_compra_pk primary key (id_detalle_orden_compra),
    constraint detalleOrdenCompra_id_orden_compra_fk foreign key (id_orden_compra) references ordenCompra (id_orden_compra) on delete cascade on update cascade,
    constraint detalleOrdenCompra_id_producto_fk foreign key (id_producto) references producto (id_producto) on delete restrict on update cascade
);

-- TABLAS PARA CUANDO SE RECIBA LA MERCANCÍA DE UNA ORDEN DE COMPRA, CUANDO SE RECIBA, SE DEBERÁ REGISTRAR EN LA TABLA TRANSACCION
-- Tabla para las entradas de mercancías
create table entradaMercancia (
    id_entrada_mercancia int auto_increment,
    id_orden_compra int not null,
    fecha_entrada timestamp default current_timestamp not null,
    constraint entradaMercancia_id_entrada_mercancia_pk primary key (id_entrada_mercancia),
    constraint entradaMercancia_id_orden_compra_fk foreign key (id_orden_compra) references ordenCompra (id_orden_compra) on delete restrict on update cascade
);

-- Detalle de la entrada de mercancía
create table detalleEntradaMercancia (
    id_detalle_entrada_mercancia int auto_increment,
    id_entrada_mercancia int not null,
    id_producto int not null,
    id_transaccion int not null,-- id que registra la transacción a la que va vinculada la entrada de esta mercancia
    cantidad_recibida int not null,
    constraint detalleEntradaMercancia_id_detalle_entrada_mercancia_pk primary key (id_detalle_entrada_mercancia),
    constraint detalleEntradaMercancia_id_entrada_mercancia_fk foreign key (id_entrada_mercancia) references entradaMercancia (id_entrada_mercancia) on delete cascade on update cascade,
    constraint detalleEntradaMercancia_id_producto_fk foreign key (id_producto) references producto (id_producto) on delete restrict on update cascade,
    constraint detalleEntradaMercancia_id_transaccion_fk foreign key (id_transaccion) references transaccion (id_transaccion) on delete restrict on update cascade
);

-- 3º GESTIÓN DE VENTAS ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

/*
	- Punto de venta (POS): Registro de transacciones de venta.
	- Registro de ventas diarias: Resumen de ventas diarias.
	- Gestión de precios y promociones: Registro de precios y promociones aplicadas.
	- Facturación y emisión de tickets de venta: Detalles de facturación.
*/

create table cliente(
	id_cliente int auto_increment,
    id_persona int not null,
    constraint cliente_id_cliente_pk primary key (id_cliente),
    constraint cliente_id_persona_fk foreign key (id_persona) references persona (id_persona)
);

/*Tablas venta, consumo y servicio son tablas de históricos, donde se guarda:
	- Venta: Ventas realizadas, con la cantidad del producto tipo venta vendido, el precio real de venta y la descripción de la venta
    - Consumo: Consumo realizado, con la cantidad de productos tipo consumo consumidos por la empresa y la descripcion del consumo
    - Servicio: Servicio realizado, con la cantidad de productos tipo servicio(horas realizadas) y el precio de cada uno
    
ej. insercion en tabla servicio:
	1º- insert into producto(nombre, descripcion, tipo_producto, id_categoria, id_subcategoria, id_unidad_medida, precio_unitario)
		values ("Reparación de electodomésticos a domicilio", "Servicio de reparación de electrodomésticos a domicilio", "servicio", 1, 1, 1, 50.00);
	2º- insert into servicio(id_producto, descripcion_servicio, precio_servicio, duracion_estimada)
		values (1, "Reparacion de electrodomesticos en domicilio X", 50.00, 6);*/
        
create table venta(
	id_venta int auto_increment,
    id_producto int not null,
    cantidad int not null,
    fecha_venta timestamp default current_timestamp not null,
    precio_venta_unitario decimal(10,2) not null,
    id_cliente int not null,
    descripcion text,
    constraint venta_id_venta_pk primary key (id_venta),
    constraint venta_id_producto_fk foreign key (id_producto) references producto (id_producto) on delete restrict on update cascade,
    constraint venta_id_cliente_fk foreign key (id_cliente) references cliente (id_cliente) on delete restrict on update cascade
);

create table servicio(
	id_servicio int auto_increment,
    id_producto int not null,
    id_cliente int not null,
    descripcion_servicio text,
    precio_servicio decimal(10, 2) not null,
    duracion_estimada time not null,/*duracion_estimada int;-- horas*/
    fecha_creacion timestamp default current_timestamp not null,
    fecha_actualizacion timestamp default current_timestamp on update current_timestamp not null,
    constraint servicio_id_servicio_pk primary key (id_servicio),
    constraint servicio_id_producto_fk foreign key (id_producto) references producto (id_producto) on delete restrict on update cascade,
    constraint servicio_id_cliente_fk foreign key (id_cliente) references cliente (id_cliente) on delete restrict on update cascade
);

create table consumo(
	id_consumo int auto_increment,
    id_producto int not null,
    cantidad int not null,
    fecha_consumo timestamp default current_timestamp not null,
    descripcion text,
    constraint consumo_id_consumo_pk primary key (id_consumo),
    constraint consumo_id_producto_fk foreign key (id_producto) references producto (id_producto) on delete restrict on update cascade
);

-- SECCION TICKET - FACTURA

create table impuesto(
	id_impuesto int auto_increment,
    porcentaje int not null,
    descripcion text,
    constraint impuesto_id_impuesto_pk primary key (id_impuesto)
);

create table descuento(
	id_descuento int auto_increment,
    porcentaje int not null,
    descripcion text,
    constraint descuento_id_descuento_pk primary key (id_descuento)
);

/*el total de la factura se tomará con las vistas y haciendo join en la tabla detalle factura. Tomar el total sin impuestos ni descuentos y el total final con todo aplicado*/
create table factura(
	id_factura int auto_increment,
    id_cliente int not null,
    fecha_factura date not null,-- fecha en que se generó la factura
    id_impuesto int not null,
    id_descuento int not null,
    estado enum('emitida', 'pagada', 'cancelada'),
    constraint factura_id_factura_pk primary key (id_factura),
    constraint factura_id_cliente_fk foreign key (id_cliente) references cliente (id_cliente) on delete restrict on update cascade,
    constraint factura_id_impuesto_fk foreign key (id_impuesto) references impuesto (id_impuesto) on delete restrict on update cascade,
    constraint factura_id_descuento_fk foreign key (id_descuento) references descuento (id_descuento) on delete restrict on update cascade
);

/*El subtotal de cada detalle de factura se tomará con las vistas*/
create table detalleFactura (
    id_detalle_factura int auto_increment,
    id_factura int not null,
    id_producto int not null,
    cantidad int not null,
    precio_unitario decimal(10, 2) not null,
    constraint detalleFactura_id_detalle_factura_pk primary key (id_detalle_factura),
    constraint detalleFactura_id_factura_fk foreign key (id_factura) references factura (id_factura) on delete cascade on update cascade,
    constraint detalleFactura_id_producto_fk foreign key (id_producto) references producto (id_producto) on delete restrict on update cascade
);

create table metodoPago(
	id_metodo_pago int auto_increment,
    nombre_metodo_pago varchar(50),
    constraint metodoPago_id_metodo_pago_pk primary key (id_metodo_pago)
);

/*El total del ticket se tomará con las vistas y haciendo join en la tabla detalle ticket. Tomar el total sin impuestos ni descuentos y el total final con todo aplicado*/
create table Ticket (
    id_ticket int auto_increment,
    id_cliente int not null,
    fecha_ticket date not null,-- fecha en que se generó el ticket
    id_impuesto int not null,
    id_descuento int not null,
    id_metodo_pago int not null,
    estado enum('abierto', 'cerrado', 'cancelado') default 'abierto' not null,
    constraint ticket_id_ticket_pk primary key (id_ticket),
    constraint ticket_id_cliente_fk foreign key (id_cliente) references cliente (id_cliente) on delete restrict on update cascade,
    constraint ticket_id_impuesto_fk foreign key (id_impuesto) references impuesto (id_impuesto) on delete restrict on update cascade,
    constraint ticket_id_descuento_fk foreign key (id_descuento) references descuento (id_descuento) on delete restrict on update cascade,
    constraint ticket_id_metodo_pago_fk foreign key (id_metodo_pago) references metodoPago (id_metodo_pago) on delete restrict on update cascade
);

/*El subtotal de cada detalle de ticket se tomará con las vistas*/
create table detalleTicket (
    id_detalle_ticket int auto_increment,
    id_ticket int not null,
    id_producto int not null,
    cantidad int not null,
    precio_unitario decimal(10, 2) not null,
    constraint detalleTicket_id_detalle_ticket_pk primary key (id_detalle_ticket),
    constraint detalleTicket_id_ticket_fk foreign key (id_ticket) references ticket (id_ticket) on delete cascade on update cascade,
    constraint detalleTicket_id_producto_fk foreign key (id_producto) references producto (id_producto) on delete restrict on update cascade
);

-- 4º GESTIÓN FINANCIERA --------------------------------------------------------------------------------------------------------------------------------------------------------------------------

/*
	- Registro de ingresos y gastos: Registro de todas las transacciones financieras.
	- Gestión de cuentas por cobrar y por pagar: Registro de deudas y pagos.
	- Conciliación bancaria: Comparación de registros contables con extractos bancarios.
	- Informes financieros básicos: Generación de informes financieros.
    
    NO NECESITA SOPORTE EN LA BBDD
*/

-- 5º CUMPLIMIENTO LEGAL Y FISCAL ---------------------------------------------------------------------------------------------------------------------------------------------------------------

/*
	- Generación de facturas y tickets conforme a la normativa española: Registro de facturas y tickets.
	- Gestión de IVA y otros impuestos: Registro de impuestos.
	- Informes y declaraciones fiscales: Generación de informes fiscales.
    
    NO NECESITA SOPORTE EN LA BBDD
*/

-- 6º INFORMES Y ANÁLISIS --------------------------------------------------------------------------------------------------------------------------------------------------------------------------

/*
	- Informes de ventas diarias, semanales y mensuales: Generación de informes de ventas.
	- Análisis de ventas por producto, categoría y proveedor: Análisis detallado de ventas.
	- Identificación de productos más y menos vendidos: Informe de popularidad de productos.
    
    NO NECESITA SOPORTE EN LA BBDD
*/

-- 7º GESTIÓN DE CAJA -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

/*
	- Control de efectivo y movimientos en caja: Registro de movimientos de efectivo.
	- Cuadre de caja diario: Reconciliación diaria de la caja.
	- Registro de formas de pago: Registro de diferentes métodos de pago.(METODO DE PAGO DEFINIDO EN SECCIÓN GESTION DE VENTAS)
*/


-- 8º GESTIÓN DE USUARIOS --------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- SECCION USUARIOS - ROLES

CREATE TABLE rol (
    id_rol int auto_increment,
    nombre_rol varchar(50) not null,
    descripcion text,
    constraint rol_id_rol_pk primary key (id_rol),
    constraint rol_nombre_rol_uq unique (nombre_rol)
);

create table usuario (
    id_usuario int auto_increment,
    nombre_usuario varchar(50) not null,
    contrasena varchar(255) not null,
    email varchar(100) UNIQUE not null,
    nombre varchar(100) not null,
    apellido varchar(100) not null,
    fecha_creacion timestamp default current_timestamp not null,
    estado enum('activo', 'inactivo') default 'activo' not null,
    id_rol int not null,
    constraint usuario_id_usuario_pk primary key (id_usuario),
    constraint usuario_nombre_usuario_uq unique (nombre_usuario),
    constraint usuario_email_uq unique (email),
    constraint usuario_id_rol_fk foreign key (id_rol) references rol (id_rol) on delete restrict on update cascade
);

create table permiso(
	id_permiso int auto_increment,
    nombre_permiso varchar(50) not null,
    descripcion text,
    constraint permiso_id_permiso_pk primary key (id_permiso),
    constraint permiso_nombre_permiso_uq unique (nombre_permiso)
);

create table rolPermiso(
	id_rol int,
    id_permiso int,
    constraint rolPermiso_multiple_pk primary key (id_rol, id_permiso),
    constraint rolPermiso_id_rol_fk foreign key (id_rol) references rol (id_rol) on delete cascade on update cascade,
    constraint rolPermiso_id_permiso_fk foreign key (id_permiso) references permiso (id_permiso) on delete cascade on update cascade
);