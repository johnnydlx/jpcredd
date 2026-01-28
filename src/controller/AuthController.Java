package com.empresa.emprestimos.controller;

import com.empresa.emprestimos.model.Cliente;
import com.empresa.emprestimos.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        try {
            String cpf = body.get("cpf");
            String senha = body.get("senha");

            Cliente cliente = authService.login(cpf, senha);

            // Aqui podemos retornar dados do cliente ou token se houver JWT
            return ResponseEntity.ok(Map.of(
                "id", cliente.getId(),
                "nome", cliente.getNome(),
                "cpf", cliente.getCpf()
            ));
        } catch (Exception e) {
            return ResponseEntity.status(401).body(Map.of("error", e.getMessage()));
        }
    }
}
