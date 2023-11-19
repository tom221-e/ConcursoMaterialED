package ar.edu.unnoba.poo2013.model.controller;

import ar.edu.unnoba.poo2013.model.model.MaterialEducativo;
import ar.edu.unnoba.poo2013.model.model.Usuario;
import ar.edu.unnoba.poo2013.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UsuarioService usuarioService;
    @GetMapping("admin/index")
    @PreAuthorize("hasRole('ROLE_Administrador')")
    public String userInSession(Authentication authentication, Model model) {
        Usuario usuario= (Usuario) authentication.getPrincipal();
        model.addAttribute("usuario", usuario);
        return "admin/index";
    }

    /*mostrar materiales en revision*/
    @PreAuthorize("#authentication.principal.isAdministrador()")
    @GetMapping("admin/administrarmaterial")
    public String Materiales(Authentication authentication, Model model) {
        model.addAttribute("materiales", usuarioService.materialesEducativosEnRevision());
        return "admin/administrarmaterial";
    }
    @PreAuthorize("#authentication.principal.isAdministrador()")  /*solo los administradores pueden aprovar materiales*/
    @GetMapping("/{id}/material")
    public String viewMaterial(@PathVariable("id") Long id, Model model) {
        model.addAttribute("material", usuarioService.getMaterialEducativoRepository().getById(id));
        return "admin/material";
    }

    /*aprobar Material*/
    @PreAuthorize("#authentication.principal.isAdministrador()")  /*solo los administradores pueden aprovar materiales*/
    @GetMapping("/{id}/aprobar")
    public String aprobarMaterial(@PathVariable("id") Long id) {
        usuarioService.updateAprobado(id);
        return "redirect:/admin/admin/administrarmaterial";
    }

    /*aprobar Material*/
    @PreAuthorize("#authentication.principal.isAdministrador()")  /*solo los administradores pueden aprovar materiales*/
    @GetMapping("/{id}/rechazar")
    public String rechazarMaterial(@PathVariable("id") Long id) {
        usuarioService.updateRechazado(id);
        return "redirect:/admin/admin/administrarmaterial";
    }
}
