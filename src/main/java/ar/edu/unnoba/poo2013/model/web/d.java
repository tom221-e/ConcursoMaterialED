package ar.edu.unnoba.poo2013.model.web;

import ar.edu.unnoba.poo2013.model.service.UsuarioService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class UploadServlet extends HttpServlet {
    UsuarioService usuarioService;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        InputStream fileContent = filePart.getInputStream();
        String savePath = "resources/material/idusuario/" + fileName;
        File file = new File(savePath);
        try (FileOutputStream out = new FileOutputStream(file)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileContent.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
        if (usuarioService != null) {
            usuarioService.getRepositorioDao().saveFilePath(savePath); // Guardar la ubicación del archivo en la base de datos.
        } else {
            // Manejar el caso en el que el DAO no está inicializado correctamente.
        }
    }
}