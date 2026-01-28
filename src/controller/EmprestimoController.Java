package com.empresa.emprestimos.controller;

import com.empresa.emprestimos.model.Emprestimo;
import com.empresa.emprestimos.service.EmprestimoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private final EmprestimoService service;

    public EmprestimoController(EmprestimoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Emprestimo> criar(@RequestBody Emprestimo emprestimo) {
        return ResponseEntity.ok(service.criarEmprestimo(emprestimo));
    }

    @GetMapping
    public ResponseEntity<List<Emprestimo>> listar() {
        return ResponseEntity.ok(service.listarEmprestimos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emprestimo> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletarEmprestimo(id);
        return ResponseEntity.noContent().build();
    }
}
