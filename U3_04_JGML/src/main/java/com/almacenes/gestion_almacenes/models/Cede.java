package com.almacenes.gestion_almacenes.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clave;

    @NotNull(message = "El estado es obligatorio")
    @Size(min = 2, max = 15, message = "El estado debe tener entre 2 y 15 caracteres")
    private String estado;

    @NotNull(message = "El municipio es obligatorio")
    @Size(min = 2, max = 15, message = "El municipio debe tener entre 2 y 15 caracteres")
    private String municipio;
}