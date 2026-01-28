package com.empresa.emprestimos.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String cpf;

    private String telefone;

    private String endereco;

    private String senha;

    private Boolean ativo = true;


    @Column(name = "criado_em")
    private LocalDateTime criadoEm;
}
