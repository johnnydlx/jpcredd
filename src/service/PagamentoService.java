package com.empresa.emprestimos.service;

import com.empresa.emprestimos.model.Pagamento;
import com.empresa.emprestimos.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    private final PagamentoRepository repository;

    public PagamentoService(PagamentoRepository repository) {
        this.repository = repository;
    }

    public Pagamento registrarPagamento(Pagamento pagamento) {
        return repository.save(pagamento);
    }

    public List<Pagamento> listarPagamentosDoEmprestimo(Long emprestimoId) {
        return repository.findByEmprestimoId(emprestimoId);
    }
}
