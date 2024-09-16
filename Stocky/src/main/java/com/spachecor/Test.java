package com.spachecor;

import com.spachecor.model.entity.compra.DetalleEntradaMercancia;
import com.spachecor.model.entity.compra.DetalleOrdenCompra;
import com.spachecor.model.entity.compra.EntradaMercancia;
import com.spachecor.model.entity.compra.OrdenCompra;
import com.spachecor.model.entity.inventario.*;
import com.spachecor.model.entity.personas.Proveedor;
import com.spachecor.model.services.repository.GenericRepositoryServiceImpl;
import com.spachecor.model.util.JpaUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Test {
    public static void main(String[] args) {
        GenericRepositoryServiceImpl<OrdenCompra> ordenCompraGenericRepositoryService = new GenericRepositoryServiceImpl<>(JpaUtil.getEntityManager(), OrdenCompra.class);
        GenericRepositoryServiceImpl<DetalleOrdenCompra> detalleOrdenCompraGenericRepository = new GenericRepositoryServiceImpl<>(JpaUtil.getEntityManager(), DetalleOrdenCompra.class);
        GenericRepositoryServiceImpl<Proveedor> proveedorGenericRepositoryService = new GenericRepositoryServiceImpl<>(JpaUtil.getEntityManager(), Proveedor.class);
        GenericRepositoryServiceImpl<Categoria> categoriaGenericRepositoryService = new GenericRepositoryServiceImpl<>(JpaUtil.getEntityManager(), Categoria.class);
        GenericRepositoryServiceImpl<Subcategoria> subcategoriaGenericRepositoryService =  new GenericRepositoryServiceImpl<>(JpaUtil.getEntityManager(), Subcategoria.class);
        GenericRepositoryServiceImpl<UnidadMedida> unidadMedidaGenericRepositoryService = new GenericRepositoryServiceImpl<>(JpaUtil.getEntityManager(), UnidadMedida.class);
        GenericRepositoryServiceImpl<Producto> productoGenericRepositoryService = new GenericRepositoryServiceImpl<>(JpaUtil.getEntityManager(), Producto.class);
        //CATEGORIAS Y SUBCATEGORIAS
        Categoria frutas = new Categoria();
        frutas.setNombre("Frutas");
        frutas.setDescripcion("Frutas");
        categoriaGenericRepositoryService.guardar(frutas);

        Subcategoria manzana = new Subcategoria();
        manzana.setNombre("Manzana");
        manzana.setDescripcion("Manzanas");
        manzana.setCategoria(frutas);
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

        //PRODUCTO
        Producto manzanaGolden = new Producto();
        manzanaGolden.setProveedor(pepes);
        manzanaGolden.setNombre("Manzana Golden");
        manzanaGolden.setDescripcion("Manzanas Golden a granel");
        manzanaGolden.setTipoProducto("Venta");
        manzanaGolden.setSubcategoria(manzana);
        manzanaGolden.setPrecioUnitario(1.5D);
        manzanaGolden.setUnidadMedida(kiloGramo);
        manzanaGolden.setActivo(true);
        manzanaGolden.setFechaCreacion(LocalDate.now());
        productoGenericRepositoryService.guardar(manzanaGolden);

        OrdenCompra ordenCompra = new OrdenCompra();
        ordenCompra.setProveedor(pepes);
        ordenCompra.setEstado("pendiente");
        ordenCompra.setFechaOrden(LocalDateTime.now());
        ordenCompra.setFechaEstimadaRecepcion(LocalDate.now().plusWeeks(5));
        ordenCompraGenericRepositoryService.guardar(ordenCompra);

        DetalleOrdenCompra detalleOrdenCompraUno = new DetalleOrdenCompra();
        detalleOrdenCompraUno.setOrdenCompra(ordenCompra);
        detalleOrdenCompraUno.setProducto(manzanaGolden);
        detalleOrdenCompraUno.setCantidad(75D);
        detalleOrdenCompraGenericRepository.guardar(detalleOrdenCompraUno);

        Lote lote = new Lote();
        lote.setProducto(manzanaGolden);
        lote.setPrecioUnitarioCompra(0.75D);
        lote.setFechaEntrada(LocalDate.now());
        lote.setFechaCaducidad(LocalDate.now().plusWeeks(4));
        lote.setCantidadInicial(75D);
        lote.setCantidadActual(75D);

        Transaccion transaccion = new Transaccion();
        transaccion.setLote(lote);
        transaccion.setFechaTransaccion(LocalDateTime.now());
        transaccion.setCantidad(1D);
        transaccion.setTipoTransaccion("entrada");

        EntradaMercancia entradaMercancia = new EntradaMercancia();
        entradaMercancia.setOrdenCompra(ordenCompra);
        entradaMercancia.setFechaEntrada(LocalDateTime.now());

        DetalleEntradaMercancia detalleEntradaMercancia = new DetalleEntradaMercancia();
        detalleEntradaMercancia.setEntradaMercancia(entradaMercancia);
        detalleEntradaMercancia.setTransaccion(transaccion);
        //todo terminar ejemplo con la entrada de mercancia

        System.out.println(detalleOrdenCompraGenericRepository.listar());
        System.out.println(ordenCompraGenericRepositoryService.listar());
    }
}
