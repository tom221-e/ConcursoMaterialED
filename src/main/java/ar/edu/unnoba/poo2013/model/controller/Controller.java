package ar.edu.unnoba.poo2013.model.controller;

import ar.edu.unnoba.poo2013.model.model.MaterialEducativo;
import ar.edu.unnoba.poo2013.model.model.Usuario;
import ar.edu.unnoba.poo2013.model.service.UsuarioService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


public class Controller {
    UsuarioService usuarioService;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        for (Usuario user : usuarioService.getAllUsuarios()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return "/material";
            }
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return "/materialAdmin";
            }

        }
        return "/login";
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


