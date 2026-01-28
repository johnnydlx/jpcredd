package com.empresa.emprestimos.service;

import com.empresa.emprestimos.model.Cliente;
import com.empresa.emprestimos.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente salvar(Cliente cliente) {
        if (repository.existsByCpf(cliente.getCpf())) {
            throw new RuntimeException("CPF já cadastrado");
        }
        return repository.save(cliente);
    }

    public List<Cliente> listar() {
        return repository.findAll();
    }
}
