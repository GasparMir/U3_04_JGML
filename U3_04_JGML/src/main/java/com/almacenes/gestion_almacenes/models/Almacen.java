package com.almacenes.gestion_almacenes.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Almacen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clave;
    private LocalDate fechaRegistro;
    private double precioVenta;
    private double precioRenta;
    private String tamano;
    @Enumerated(EnumType.STRING)
    private EstadoAlmacen estado = EstadoAlmacen.DISPONIBLE;

    @ManyToOne
    @JoinColumn(name = "cede_id")
    private Cede cede;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    

}