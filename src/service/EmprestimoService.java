package com.empresa.emprestimos.service;

import com.empresa.emprestimos.model.Emprestimo;
import com.empresa.emprestimos.repository.EmprestimoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    private final EmprestimoRepository repository;

    public EmprestimoService(EmprestimoRepository repository) {
        this.repository = repository;
    }

    public Emprestimo criarEmprestimo(Emprestimo emprestimo) {
        return repository.save(emprestimo);
    }

    public List<Emprestimo> listarEmprestimos() {
        return repository.findAll();
    }

    public Optional<Emprestimo> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletarEmprestimo(Long id) {
        repository.deleteById(id);
    }

    public List<Emprestimo> listarEmprestimosAtivos() {
        return repository.findByAtivoTrue();
    }
}
