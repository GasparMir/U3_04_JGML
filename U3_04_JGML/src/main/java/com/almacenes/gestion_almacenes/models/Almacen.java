package com.almacenes.gestion_almacenes.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.*;

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

    @NotNull(message = "La fecha de registro es obligatoria")
    private LocalDate fechaRegistro;

    @NotNull(message = "El precio de venta es obligatorio")
    @Positive(message = "El precio de venta no puede ser negativo")
    private double precioVenta;

    @NotNull(message = "El precio de renta es obligatorio")
    @Positive(message = "El precio de renta no puede ser negativo")
    private double precioRenta;

    @NotNull(message = "El tamaño es obligatorio")
    @Size(min = 1, max = 20, message = "El tamaño debe tener entre 1 y 20 caracteres")
    private String tamano;

    @Enumerated(EnumType.STRING)
    private EstadoAlmacen estado = EstadoAlmacen.DISPONIBLE;

    @ManyToOne
    @JoinColumn(name = "cede_id")
    @NotNull(message = "La cede es obligatoria")
    private Cede cede;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}