package com.elenakeepcoding.web.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	
	@GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Bienvenido a la página de adopción de mascotas");
        return "index";
    }

    @GetMapping("/mascotas")
    public String mascotas() {
        return "mascotas";
    }

    @GetMapping("/propietarios")
    public String propietarios() {
        return "propietarios";
    }

    @GetMapping("/registro")
    public String regMascotas() {
        return "registro";
    }
    
    @GetMapping("/youngest-masc")
    public String youngestMascotas() {
        return "youngest-masc";
    }
    
    @GetMapping("/contacto")
    public String contacto() {
        return "contacto";
    }
    
    

}
