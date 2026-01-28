package com.empresa.emprestimos.controller;

import com.empresa.emprestimos.model.Pagamento;
import com.empresa.emprestimos.service.PagamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    private final PagamentoService service;

    public PagamentoController(PagamentoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Pagamento> criar(@RequestBody Pagamento pagamento) {
        return ResponseEntity.ok(service.registrarPagamento(pagamento));
    }

    @GetMapping("/emprestimo/{id}")
    public ResponseEntity<List<Pagamento>> listarPorEmprestimo(@PathVariable Long id) {
        return ResponseEntity.ok(service.listarPagamentosDoEmprestimo(id));
    }
}
