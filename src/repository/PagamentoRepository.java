package com.empresa.emprestimos.repository;

import com.empresa.emprestimos.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    List<Pagamento> findByEmprestimoId(Long emprestimoId);
}
