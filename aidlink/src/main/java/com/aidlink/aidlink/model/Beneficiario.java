package com.aidlink.aidlink.model; // DEBE coincidir con la carpeta 'model'

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table; // Importación necesaria
import lombok.Data; // Requiere la dependencia de Lombok en tu pom.xml

@Entity
@Data
@Table(name = "beneficiario") // Mapea explícitamente a la tabla de MySQL
public class Beneficiario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String folioUnico;
    private String nombreCompleto;
    private String programaSocial;
    private Boolean verificado;
}