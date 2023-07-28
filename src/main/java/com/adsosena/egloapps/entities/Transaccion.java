package com.adsosena.egloapps.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "transacciones")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "tipo_operacion", nullable = false)
    @Enumerated(EnumType.STRING)
    private Operacion tipoDeOperacion;

    @Column(name = "metodo_de_pago")
    private String metodoDePago;

    @Column(name = "total")
    private double total;

    @Column(name = "fecha_realizacion", nullable = false)
    private Timestamp fechaDeRealizacion;
}
