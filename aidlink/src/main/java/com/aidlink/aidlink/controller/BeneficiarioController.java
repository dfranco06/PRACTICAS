package com.aidlink.aidlink.controller;

import com.aidlink.aidlink.model.Beneficiario; // ¡Esta importación es la clave!
import com.aidlink.aidlink.repository.BeneficiarioRepository; // Esta importación es la clave!
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Controller
public class BeneficiarioController {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    // ... (Método generarFolioUnico - No se muestra por espacio, pero ya es correcto)

    // ... (Método inicio - Ya es correcto)

    // ... (Método verificarFolio - Ya es correcto)

    @PostMapping("/registrar")
    @Transactional // Asegura que se complete la inserción en la BD
    // Cambia esto (si estaba sin modificador o mal):
// String generarFolioUnico(String programa) { ... }

// A esto:
    private String generarFolioUnico(String programa) {
        String iniciales = Optional.ofNullable(programa)
                .orElse("")
                .replaceAll("[^A-Za-z0-9]", "");

        // Toma las primeras dos letras, si existen
        iniciales = iniciales.length() > 2 ? iniciales.substring(0, 2).toUpperCase() : iniciales.toUpperCase();

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss"));
        return iniciales.isEmpty() ? "F-" + timestamp : iniciales + "-" + timestamp;
    }
}