package com.aidlink.aidlink.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data; // IMPORTANTE
import lombok.NoArgsConstructor;

@Entity
@Data // Genera automáticamente Getters, Setters, toString, hashCode, equals
@NoArgsConstructor // Necesario para JPA
public class Beneficiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String folioUnico; // Debe existir
    private String nombreCompleto; // Debe existir
    private String programaSocial; // Debe existir
    private Boolean verificado; // Debe existir

    // Si tienes @Data, NO necesitas escribir los Getters y Setters

}