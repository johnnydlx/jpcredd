package com.empresa.emprestimos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.empresa.emprestimos.model.Cliente;
import com.empresa.emprestimos.repository.ClienteRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final ClienteRepository clienteRepository;

    public DataLoader(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (clienteRepository.count() == 0) {
            Cliente c = new Cliente();
            c.setNome("Teste Login");
            c.setCpf("12345678900");
            c.setSenha("1234");
            c.setAtivo(true);

            clienteRepository.save(c);
            System.out.println("Cliente de teste criado: CPF=12345678900 / Senha=1234");
        }
    }
}
