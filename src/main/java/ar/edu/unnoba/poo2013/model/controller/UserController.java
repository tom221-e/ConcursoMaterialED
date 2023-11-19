package ar.edu.unnoba.poo2013.model.controller;

import ar.edu.unnoba.poo2013.model.model.MaterialEducativo;
import ar.edu.unnoba.poo2013.model.model.Usuario;
import ar.edu.unnoba.poo2013.model.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    UsuarioService usuarioService;

    /* Opciones de usuario en sesion*/
    @GetMapping("/index")
    public String userInSession(Authentication authentication, Model model) {
        Usuario usuario= (Usuario) authentication.getPrincipal();
        model.addAttribute("usuario", usuario);
        return "users/index";
    }
    /*separa los usuarios dependiendo si son participantes o administradores*/
    @GetMapping("/login")
    public String login(Authentication authentication) {
        Usuario user = (Usuario) authentication.getPrincipal();
        if (user.isParticipante()) {
                return "redirect:/users/index";
            }
        if (user.isAdministrador()) {
                return "redirect:/admin/admin/index";
            }
        else {
            return "redirect:/login?error";
        }
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
    @GetMapping("/material")
    public String newMaterial(Model model, Authentication authentication) {
        Usuario usuario= (Usuario) authentication.getPrincipal();
        MaterialEducativo materialEducativo=usuario.getMaterialEducativo();
        if(usuario.getMaterialEducativo() == null) {
            model.addAttribute("material", new MaterialEducativo());
            return "users/material";
        }
        else{
            model.addAttribute("material", usuario.getMaterialEducativo());
            return "users/materialcargado";
        }
    }
    @PreAuthorize("#authentication.principal.isParticipante()")
    @PostMapping
    public String createMaterial(@ModelAttribute MaterialEducativo material, Authentication authentication){
        Usuario usuario= (Usuario) authentication.getPrincipal();
        MaterialEducativo nuevoMaterial = usuarioService.getMaterialEducativoRepository().save(material);
        Usuario u2= usuarioService.getUsuarioRepository().findOneByUsername(usuario.getUsername());
        u2.setMaterialEducativo(nuevoMaterial);
        usuarioService.getUsuarioRepository().save(u2);
        return "redirect:/material";

    }
    /*Ver materiar del usuario en sesion*/
    @PreAuthorize("#authentication.principal.isParticipante()")  /*Solo los administradores pueden acceder*/
    @GetMapping("/materialview")
    public String publicarMaterial(Model model, Authentication authentication) {
        Usuario usuario= (Usuario) authentication.getPrincipal();
        MaterialEducativo materialEducativo= usuario.getMaterialEducativo();
        model.addAttribute("material", materialEducativo);
        return "/users/materialview";
    }

}


