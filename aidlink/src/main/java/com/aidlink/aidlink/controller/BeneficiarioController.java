package com.aidlink.aidlink.controller;

import com.aidlink.aidlink.model.Beneficiario;
import com.aidlink.aidlink.repository.BeneficiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class BeneficiarioController {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    // Página principal con formularios
    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("nuevoBeneficiario", new Beneficiario());
        return "index";
    }

    // Registro de beneficiario con validación
    @PostMapping("/registrar")
    public String registrarBeneficiario(@ModelAttribute("nuevoBeneficiario") Beneficiario nuevoBeneficiario,
                                        RedirectAttributes redirectAttributes) {

        // Validación: campos obligatorios
        if (nuevoBeneficiario.getNombreCompleto() == null || nuevoBeneficiario.getNombreCompleto().trim().isEmpty() ||
                nuevoBeneficiario.getProgramaSocial() == null || nuevoBeneficiario.getProgramaSocial().trim().isEmpty()) {

            redirectAttributes.addFlashAttribute("resultadoRegistro", "❌ Error: Debes ingresar nombre y programa.");
            return "redirect:/";
        }

        // Generar folio único
        String nuevoFolio = generarFolioUnico(nuevoBeneficiario.getProgramaSocial());
        nuevoBeneficiario.setFolioUnico(nuevoFolio);
        nuevoBeneficiario.setVerificado(true);

        // Guardar en la base de datos
        beneficiarioRepository.save(nuevoBeneficiario);
        System.out.println("✅ Registro guardado: " + nuevoBeneficiario.getNombreCompleto());

        // Mensaje de éxito
        redirectAttributes.addFlashAttribute("resultadoRegistro", "✅ Registro exitoso.");
        redirectAttributes.addFlashAttribute("folioGenerado", nuevoFolio);

        return "redirect:/";
    }

    // Generador de folio único
    private String generarFolioUnico(String programa) {
        String iniciales = programa.replaceAll("[^A-Za-z0-9]", "").substring(0, Math.min(programa.length(), 2)).toUpperCase();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss"));
        return iniciales + "-" + timestamp;
    }
}