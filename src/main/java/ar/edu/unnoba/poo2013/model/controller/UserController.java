package ar.edu.unnoba.poo2013.model.controller;

import ar.edu.unnoba.poo2013.model.model.MaterialEducativo;
import ar.edu.unnoba.poo2013.model.model.Usuario;
import ar.edu.unnoba.poo2013.model.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/users")
public class UserController {
    UsuarioService usuarioService;

    /* Opciones de usuario en sesion*/
    @GetMapping("users/index")
    public String userInSession(Authentication authentication, Model model) {
        model.addAttribute("usuario", authentication.getPrincipal());
        return "users/index";
    }
    /*separa los usuarios dependiendo si son participantes o administradores*/
    @PostMapping("/login")
    public String login(Authentication authentication) {
        Usuario user = (Usuario) authentication.getPrincipal();
        if (user.isParticipante()) {
                return "users/index";
            }
        if (user.isAdministrador()) {
                return "admin/index";
            }
        return null;
    }
    /*Cerrar sesion*/
    @GetMapping("/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
    /*crear Nuevo Material*/
    @PreAuthorize("#authentication.principal.isParticipante()")  /*solo los participante pueden cargar material*/
    @PostMapping("users/material")
    public String newMaterial(Model model, Authentication authentication) {
        Usuario usuario= (Usuario) authentication.getPrincipal();
        if(usuario.getMaterialEducativo() != null) {
            model.addAttribute("material", new MaterialEducativo());
            return "/users/material";
        }
        else{
            return "/users/materialcargado";
        }
    }
    @PreAuthorize("#authentication.principal.isParticipante()")
    @PostMapping
    public String createMaterial(@ModelAttribute MaterialEducativo material){
        material.setEnRevision();
        usuarioService.cargarMaterial(material);
        return "redirect:/material";
    }
    /*Ver materiar del usuario en sesion*/
    @PreAuthorize("#authentication.principal.isParticipante()")  /*Solo los administradores pueden acceder*/
    @PostMapping("users/materialview")
    public String publicarMaterial(Model model, Authentication authentication) {
        Usuario usuario= (Usuario) authentication.getPrincipal();
        MaterialEducativo materialEducativo= usuario.getMaterialEducativo();
        model.addAttribute("material", materialEducativo);
        return "/users/materialview";
    }

}


