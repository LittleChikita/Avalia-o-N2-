package com.example.demo.service;

import com.example.demo.dtos.LoginResponseDTO;
import com.example.demo.models.entities.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthSecurityService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public LoginResponseDTO autenticar(String email, String senha) {

        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario == null) {
            return new LoginResponseDTO("Erro ao realizar login", false);
        }

        boolean senhaCorreta = passwordEncoder.matches(senha, usuario.getSenha());

        if (!senhaCorreta) {
            return new LoginResponseDTO("Erro ao realizar login", false);
        }

        return new LoginResponseDTO("Autenticado com sucesso", true);
    }
}
