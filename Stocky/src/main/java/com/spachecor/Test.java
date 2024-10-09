package com.spachecor;

import com.spachecor.model.entity.inventario.*;
import com.spachecor.model.entity.personas.Cliente;
import com.spachecor.model.entity.personas.Proveedor;
import com.spachecor.model.entity.ticketfactura.*;
import com.spachecor.model.entity.venta.Venta;
import com.spachecor.model.services.repository.GenericRepositoryServiceImpl;
import com.spachecor.model.util.JpaUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public class Test {
    public static void main(String[] args) {
        GenericRepositoryServiceImpl<Proveedor> proveedorGenericRepositoryService = new GenericRepositoryServiceImpl<>(JpaUtil.getEntityManager(), Proveedor.class);
        GenericRepositoryServiceImpl<Categoria> categoriaGenericRepositoryService = new GenericRepositoryServiceImpl<>(JpaUtil.getEntityManager(), Categoria.class);
        GenericRepositoryServiceImpl<Subcategoria> subcategoriaGenericRepositoryService =  new GenericRepositoryServiceImpl<>(JpaUtil.getEntityManager(), Subcategoria.class);
        GenericRepositoryServiceImpl<UnidadMedida> unidadMedidaGenericRepositoryService = new GenericRepositoryServiceImpl<>(JpaUtil.getEntityManager(), UnidadMedida.class);
        GenericRepositoryServiceImpl<Producto> productoGenericRepositoryService = new GenericRepositoryServiceImpl<>(JpaUtil.getEntityManager(), Producto.class);
        GenericRepositoryServiceImpl<Lote> loteGenericRepositoryService = new GenericRepositoryServiceImpl<>(JpaUtil.getEntityManager(), Lote.class);
        GenericRepositoryServiceImpl<Cliente> clienteGenericRepositoryService = new GenericRepositoryServiceImpl<>(JpaUtil.getEntityManager(), Cliente.class);
        //GenericRepositoryServiceImpl<Venta> ventaGenericRepositoryService = new GenericRepositoryServiceImpl<>(JpaUtil.getEntityManager(), Venta.class);
        GenericRepositoryServiceImpl<MetodoPago> metodoPagoGenericRepositoryService =  new GenericRepositoryServiceImpl<>(JpaUtil.getEntityManager(), MetodoPago.class);
        GenericRepositoryServiceImpl<Descuento> descuentoGenericRepositoryService = new GenericRepositoryServiceImpl<>(JpaUtil.getEntityManager(), Descuento.class);
        GenericRepositoryServiceImpl<Impuesto> impuestoGenericRepositoryService = new GenericRepositoryServiceImpl<>(JpaUtil.getEntityManager(), Impuesto.class);
        GenericRepositoryServiceImpl<Ticket> ticketGenericRepositoryService = new GenericRepositoryServiceImpl<>(JpaUtil.getEntityManager(), Ticket.class);
        GenericRepositoryServiceImpl<DetalleTicket> detalleTicketGenericRepositoryService = new GenericRepositoryServiceImpl<>(JpaUtil.getEntityManager(), DetalleTicket.class);
        //CATEGORIAS Y SUBCATEGORIAS
        Categoria frutas = new Categoria();
        frutas.setNombre("Frutas");
        frutas.setDescripcion("Frutas");
        categoriaGenericRepositoryService.guardar(frutas);
        Subcategoria manzana = new Subcategoria();
        manzana.setNombre("Manzana");
        manzana.setDescripcion("Manzanas");
        manzana.setCategoria(categoriaGenericRepositoryService.porId(frutas.getId()).get());
        subcategoriaGenericRepositoryService.guardar(manzana);
        //UNIDAD DE MEDIDA
        UnidadMedida kiloGramo = new UnidadMedida();
        kiloGramo.setNombre("Kilogramo");
        kiloGramo.setDescripcion("Kilogramos");
        unidadMedidaGenericRepositoryService.guardar(kiloGramo);
        //PROVEEDOR
        Proveedor pepes = new Proveedor();
        pepes.setNombre("Paco García");
        pepes.setTelefono("+34696585474");
        pepes.setActivo(true);
        pepes.setContactoPrincipal("Paco García");
        pepes.setNombreEmpresa("Pepe's Brothers");
        pepes.setTipo("Proveedor");
        proveedorGenericRepositoryService.guardar(pepes);
        Optional<Proveedor> proveedorGuardado = proveedorGenericRepositoryService.porId(pepes.getId());
        //PRODUCTO
        Producto manzanaGolden = new Producto();
        if(proveedorGuardado.isPresent())manzanaGolden.setProveedor(proveedorGuardado.get());
        else manzanaGolden.setProveedor(pepes);
        manzanaGolden.setNombre("Manzana Golden");
        manzanaGolden.setDescripcion("Manzanas Golden a granel");
        manzanaGolden.setTipoProducto("Venta");
        manzanaGolden.setSubcategoria(subcategoriaGenericRepositoryService.porId(manzana.getId()).get());
        manzanaGolden.setPrecioUnitario(1.5D);
        manzanaGolden.setUnidadMedida(kiloGramo);
        manzanaGolden.setActivo(true);
        manzanaGolden.setFechaCreacion(LocalDate.now());
        productoGenericRepositoryService.guardar(manzanaGolden);
        //LOTE
        Lote lote = new Lote();
        Producto producto = productoGenericRepositoryService.porId(manzanaGolden.getId()).get();
        lote.setProducto(producto);
        lote.setCantidadInicial(50D);
        lote.setCantidadActual(50D);
        lote.setFechaEntrada(LocalDate.now());
        lote.setFechaCaducidad(LocalDate.now().plusMonths(1));
        lote.setPrecioUnitarioCompra(0.75D);
        loteGenericRepositoryService.guardar(lote);
        //CLIENTE
        Cliente cliente = new Cliente();
        cliente.setNombre("Ana");
        cliente.setDireccion("Calle margarita 1");
        cliente.setTelefono("+34696585475");
        cliente.setEmail("ana@gmail.com");
        cliente.setContactoPrincipal("Ana");
        cliente.setActivo(true);
        clienteGenericRepositoryService.guardar(cliente);
        System.out.println(cliente.getNombre());
        Optional<Cliente> clienteGuardado = clienteGenericRepositoryService.porId(cliente.getId());
        //VENTA
        /*Venta venta = new Venta();
        venta.setLote(lote);
        venta.setCantidad(1D);
        venta.setFechaVenta(LocalDateTime.now());
        venta.setPrecioVentaUnitario(1.5D);
        if(clienteGuardado.isPresent()){
            venta.setCliente(clienteGuardado.get());
            System.out.println(clienteGuardado.get().getId());
        }
        else venta.setCliente(cliente);
        venta.setTipo("venta");
        ventaGenericRepositoryService.guardar(venta);

        System.out.println(ventaGenericRepositoryService.listar());*/
        MetodoPago efectivo = new MetodoPago();
        efectivo.setNombre("Efectivo");
        metodoPagoGenericRepositoryService.guardar(efectivo);

        Descuento descuento = new Descuento();
        descuento.setPorcentaje(10);
        descuentoGenericRepositoryService.guardar(descuento);

        Impuesto impuesto = new Impuesto();
        impuesto.setPorcentaje(21);
        impuestoGenericRepositoryService.guardar(impuesto);

        Ticket ticket = new Ticket();
        ticket.setCliente(cliente);
        ticket.setFechaTicket(LocalDateTime.now());
        ticket.setDescuento(descuento);
        ticket.setImpuesto(impuesto);
        ticket.setMetodoPago(efectivo);
        ticket.setEstado("abierto");
        ticketGenericRepositoryService.guardar(ticket);

        DetalleTicket detalleTicket = new DetalleTicket();
        detalleTicket.setTicket(ticket);
        detalleTicket.setLote(lote);
        detalleTicket.setCantidad(5D);
        detalleTicket.setPrecioUnitario(3D);
        detalleTicketGenericRepositoryService.guardar(detalleTicket);

    }
}
