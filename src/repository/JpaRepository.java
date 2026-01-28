package com.empresa.emprestimos.repository;

import com.empresa.emprestimos.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByCpfAndSenha(String cpf, String senha);
}
