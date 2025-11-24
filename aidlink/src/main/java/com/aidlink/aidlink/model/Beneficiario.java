package com.aidlink.aidlink.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
public class Beneficiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String folioUnico;
    private String nombreCompleto;
    private String programaSocial;

    private String verificado;
    private LocalDate fechaRegistro;
    private int vecesConsultado;
    private LocalDateTime ultimaConsulta;

}

