package com.loginteste2.logintestee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String exibirFormularioLogin() {
        return "index.html";
    }

    @PostMapping("/voltar")
    public String realizarLogin(@Valid @RequestParam String username, @Valid @RequestParam String senha,
            BindingResult bindingResult, Model model) {

        user usuario = userService.findUserByUsername(username);

        if (usuario == null || !usuario.getSenha().equals(senha)) {
            model.addAttribute("erro", "Login inválido.");
            return "recuperar.html";
        }

        return "redirect:/voltar";
    }

    @GetMapping("/recuperar")
    public String exibirPaginaEsqueceuSenha() {
        return "recuperar.html";
    }

    @GetMapping("/voltar")
    public String voltar() {
        return "index.html";
    }
}