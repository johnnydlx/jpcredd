package com.empresa.emprestimos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.empresa.emprestimos.service.ClienteService;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public String login(@RequestParam String cpf, @RequestParam String senha) {
        boolean sucesso = clienteService.validarLogin(cpf, senha);
        return sucesso ? "Login OK" : "Login incorreto";
    }
}
