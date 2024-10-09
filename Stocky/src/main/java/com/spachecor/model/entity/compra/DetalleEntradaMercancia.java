package com.spachecor.model.entity.compra;

import com.spachecor.model.entity.Entidad;
import com.spachecor.model.entity.inventario.Lote;
import com.spachecor.model.entity.inventario.Transaccion;
import jakarta.persistence.*;

@Entity
@Table(name = "detalleEntradaMercancia")
public class DetalleEntradaMercancia extends Entidad<DetalleEntradaMercancia> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_entrada_mercancia")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_entrada_mercancia")
    private EntradaMercancia entradaMercancia;
    @ManyToOne
    @JoinColumn(name = "id_transaccion")
    private Transaccion transaccion;

    public DetalleEntradaMercancia() {}

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "DetalleEntradaMercancia{" +
                "id=" + id +
                ", entradaMercancia=" + entradaMercancia +
                ", transaccion=" + transaccion +
                '}';
    }

    @Override
    public int compareTo(DetalleEntradaMercancia o) {
        //2 detalles de entrada de mercancia son iguales si comparten la misma entrada de mercancia y la misma transaccion
        if(this.getEntradaMercancia().compareTo(o.getEntradaMercancia()) == 0 && this.getTransaccion().compareTo(o.getTransaccion()) == 0){
            return 0;
        }else return -1;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    public EntradaMercancia getEntradaMercancia() {
        return entradaMercancia;
    }

    public void setEntradaMercancia(EntradaMercancia entradaMercancia) {
        this.entradaMercancia = entradaMercancia;
    }
}
