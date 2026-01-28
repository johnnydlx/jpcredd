package com.empresa.emprestimos.config;

import com.empresa.emprestimos.repository.ClienteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SecurityConfig {

    private final ClienteRepository clienteRepository;

    public SecurityConfig(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> clienteRepository.findByCpf(username)
                .map(c -> org.springframework.security.core.userdetails.User
                        .withUsername(c.getCpf())
                        .password(c.getSenha())
                        .roles("USER")
                        .build())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance()); // para testes, sem criptografia
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
