package org.springmvcdemo.springmvcdemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller // steorype = component-scanned
public class LoginController {

    @PostMapping("/iniciarSesion")
    public String login(@RequestParam String usuario, @RequestParam String password, Model model) {

        //Logica para validacion de usuario y contraseña
        if (!usuario.isBlank() || !password.isBlank()) {
            model.addAttribute("usuario", usuario);
        } else {
            model.addAttribute("mensajeError", "Debes ingresar usuario y contraseña");
            return "error";
        }

        return "dashboard";
    }

}
