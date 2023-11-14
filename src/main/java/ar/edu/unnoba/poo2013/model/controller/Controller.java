package ar.edu.unnoba.poo2013.model.controller;

import ar.edu.unnoba.poo2013.model.model.MaterialEducativo;
import ar.edu.unnoba.poo2013.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;


public class Controller {
    UsuarioService usuarioService;
    @Value("${file.upload-dir}")
    private String uploadDir;

    @PostMapping("/material")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        try {
            // Verificar si el archivo no está vacío y si es un archivo PDF
            if (file.isEmpty() || !file.getContentType().equals("application/pdf")) {
                // Lógica para manejar errores, si es necesario
            }

            // Generar un nombre de archivo único
            String filename = UUID.randomUUID().toString() + ".pdf";
            // Obtener la ruta completa para almacenar el archivo
            Path path = Paths.get(uploadDir + filename);
            // Guardar el archivo en el directorio especificado
            Files.copy(file.getInputStream(), path);

            MaterialEducativo materialAprovado=new MaterialEducativo();
            materialAprovado.setCreador("nombre del usuario que lo subio"); //podria ser el id o el nombre
            materialAprovado.setUbicacion(path); //direccion de guardado
            usuarioService.getRepositorioDao().getMaterialEducativo().add(materialAprovado);

        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir durante el proceso de carga
        }
        return "/material";

    }
}


