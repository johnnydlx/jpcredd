package com.empresa.emprestimos.service;

import com.empresa.emprestimos.model.Cliente;
import com.empresa.emprestimos.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final ClienteRepository clienteRepository;

    public AuthService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente login(String cpf, String senha) throws Exception {
        // Busca o cliente pelo CPF
        Cliente cliente = clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new Exception("CPF não encontrado"));

        // Verifica se a senha bate
        if (!cliente.getSenha().equals(senha)) {
            throw new Exception("Senha incorreta");
        }

        // Verifica se o cliente está ativo
        if (!Boolean.TRUE.equals(cliente.getAtivo())) {
            throw new Exception("Usuário inativo");
        }

        return cliente; // retorna os dados do cliente se tudo estiver certo
    }
}
