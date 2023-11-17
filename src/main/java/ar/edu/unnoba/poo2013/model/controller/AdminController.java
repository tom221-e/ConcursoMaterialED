package ar.edu.unnoba.poo2013.model.controller;

import ar.edu.unnoba.poo2013.model.model.MaterialEducativo;
import ar.edu.unnoba.poo2013.model.service.UsuarioService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    UsuarioService usuarioService;

    @PreAuthorize("#authentication.principal.isAdministrador()")
    @GetMapping("admin/index")
    public String userInSession(Authentication authentication, Model model) {
        model.addAttribute("usuario", authentication.getPrincipal());
        return "admin/index";
    }

    /*mostrar materiales en revision*/
    @PreAuthorize("#authentication.principal.isAdministrador()")
    @GetMapping("admin/administrarmaterial")
    public String Materiales(Authentication authentication, Model model) {
        model.addAttribute("materiales", usuarioService.materialesEducativosEnRevision());
        return "admin/administrarmaterial";
    }

    /*aprobar Material*/
    @PreAuthorize("#authentication.principal.isAdministrador()")  /*solo los administradores pueden aprovar materiales*/
    @PostMapping("admin/administrarmaterial")
    public String aprobarMaterial(@ModelAttribute MaterialEducativo material) {
        material.setAprobado();
        return "redirect:/administrarmaterial";
    }

    /*aprobar Material*/
    @PreAuthorize("#authentication.principal.isAdministrador()")  /*solo los administradores pueden aprovar materiales*/
    @PostMapping("admin/administrarmaterial")
    public String rechazarMaterial(@ModelAttribute MaterialEducativo material) {
        material.setRechazado();
        return "redirect:/administrarmaterial";
    }
}
