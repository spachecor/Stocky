package com.spachecor.model.entity.venta;

import com.spachecor.model.entity.inventario.Producto;
import jakarta.persistence.*;

@Entity
@Table(name = "venta")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;
    //TODO TERRIBLE REDUNDANTE
}
