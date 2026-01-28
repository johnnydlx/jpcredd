package com.empresa.emprestimos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.empresa.emprestimos.model.Cliente;
import com.empresa.emprestimos.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public boolean validarLogin(String cpf, String senha) {
        Cliente cliente = clienteRepository.findByCpf(cpf);
        if (cliente != null && cliente.getSenha().equals(senha)) {
            return true;
        }
        return false;
    }
}
