package com.aidlink.aidlink.controller;

import com.aidlink.aidlink.model.Beneficiario;
import com.aidlink.aidlink.repository.BeneficiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


@Controller
public class BeneficiarioController {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("nuevoBeneficiario", new Beneficiario());
        return "index";
    }

    @PostMapping("/registrar")
    public String registrarBeneficiario(@ModelAttribute("nuevoBeneficiario") Beneficiario nuevoBeneficiario,
                                        RedirectAttributes redirectAttributes) {

        System.out.println("🧪 MÉTODO EJECUTADO");
        System.out.println("🧪 Recibido nombre: " + nuevoBeneficiario.getNombreCompleto());
        System.out.println("🧪 Recibido programa: " + nuevoBeneficiario.getProgramaSocial());


        if (nuevoBeneficiario.getNombreCompleto() == null || nuevoBeneficiario.getNombreCompleto().trim().isEmpty() ||
                nuevoBeneficiario.getProgramaSocial() == null || nuevoBeneficiario.getProgramaSocial().trim().isEmpty()) {

            redirectAttributes.addFlashAttribute("resultadoRegistro", "❌ Error: Debes ingresar nombre y programa.");
            return "redirect:/";
        }

        String nuevoFolio = generarFolioUnico(nuevoBeneficiario.getProgramaSocial());
        nuevoBeneficiario.setFolioUnico(nuevoFolio);

        nuevoBeneficiario.setVerificado("EN PROCESO");
        nuevoBeneficiario.setFechaRegistro(LocalDate.now());
        nuevoBeneficiario.setVecesConsultado(0);
        nuevoBeneficiario.setUltimaConsulta(null);

        try {
            beneficiarioRepository.save(nuevoBeneficiario);
            System.out.println("✅ Registro guardado en la base de datos.");
            redirectAttributes.addFlashAttribute("resultadoRegistro", "✅ Registro exitoso.");
            redirectAttributes.addFlashAttribute("folioGenerado", nuevoFolio);
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("resultadoRegistro", "❌ Error al guardar en la base de datos.");
        }

        return "redirect:/";
    }
    @PostMapping("/verificar")
    public String verificarFolio(@RequestParam String folio, Model model) {
        System.out.println("🧪 MÉTODO VERIFICAR EJECUTADO");

        Beneficiario beneficiario = beneficiarioRepository.findByFolioUnico(folio);

        if (beneficiario != null) {
            beneficiario.setVecesConsultado(beneficiario.getVecesConsultado() + 1);
            beneficiario.setUltimaConsulta(LocalDateTime.now());

            long minutos = ChronoUnit.MINUTES.between(beneficiario.getFechaRegistro().atStartOfDay(), LocalDateTime.now());
            if (minutos >= 2) {
                beneficiario.setVerificado("ENTREGADO");
            } else {
                beneficiario.setVerificado("EN PROCESO");
            }

            beneficiarioRepository.save(beneficiario);

            model.addAttribute("resultadoConsulta", "✅ El apoyo fue encontrado!");
            model.addAttribute("beneficiarioConsulta", beneficiario);
        } else {
            model.addAttribute("resultadoConsulta", "❌ No se encontró ningún apoyo con ese folio. Vuelve a intentarlo con un folio/código válido.");
        }

        model.addAttribute("nuevoBeneficiario", new Beneficiario());
        return "index";
    }
    private String generarFolioUnico(String programa) {
        String iniciales = programa.replaceAll("[^A-Za-z0-9]", "").substring(0, Math.min(programa.length(), 2)).toUpperCase();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss"));
        return iniciales + "-" + timestamp;
    }
}