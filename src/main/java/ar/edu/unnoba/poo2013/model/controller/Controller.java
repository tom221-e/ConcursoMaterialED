package ar.edu.unnoba.poo2013.model.controller;

import ar.edu.unnoba.poo2013.model.model.MaterialEducativo;
import ar.edu.unnoba.poo2013.model.model.Usuario;
import ar.edu.unnoba.poo2013.model.service.UsuarioService;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class Controller {
    UsuarioService usuarioService;

    @PostMapping("/login")
    public String login(Authentication authentication) {
        Usuario user = (Usuario) authentication.getPrincipal();
        if (user.isParticipante()) {
                return "/material";
            }
        if (user.isAdministrador()) {
                return "/materialAdmin";
            }
        return null;
    }

    @PostMapping("/material")
    public String newUser(Model model) {
        model.addAttribute("material", new MaterialEducativo());
        return "/material";
    }
    @PostMapping
    public String create(@ModelAttribute MaterialEducativo material){
        usuarioService.cargarMaterial(material);
        return "redirect:/material";
    }
}


