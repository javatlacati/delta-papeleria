package entidades;
// Generated 20-jun-2014 23:45:39 by Hibernate Tools 3.2.1.GA


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Detallecompra generated by hbm2java
 */
@Entity
@Getter
@Setter
public class Detallecompra implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//assigned
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Compra compra;
    @ManyToOne(fetch = FetchType.LAZY)
    private Producto producto; //fetch="select" lazy = "false"
    @Column(nullable = false)
    private int preciounidad;
    @Column(nullable = false)
    private int cantidad;

    public Detallecompra() {
    }

    public Detallecompra(int id, Compra compra, Producto producto, int preciounidad, int cantidad) {
        this.id = id;
        this.compra = compra;
        this.producto = producto;
        this.preciounidad = preciounidad;
        this.cantidad = cantidad;
    }

}


