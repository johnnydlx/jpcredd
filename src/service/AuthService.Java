package com.empresa.emprestimos.service;

import com.empresa.emprestimos.model.Usuario;
import com.empresa.emprestimos.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;

    public AuthService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario login(String cpf, String senha) throws Exception {
        Usuario usuario = usuarioRepository.findByCpf(cpf);
        if (usuario == null) throw new Exception("CPF não encontrado");
        if (!usuario.getSenha().equals(senha)) throw new Exception("Senha incorreta");
        if (!Boolean.TRUE.equals(usuario.getAtivo())) throw new Exception("Usuário inativo");
        return usuario;
    }
}
