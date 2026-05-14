package com.example.demo.service;

import com.example.demo.dtos.UsuarioRequestDTO;
import com.example.demo.dtos.UsuarioResponseDTO;
import com.example.demo.models.entities.Usuario;
import com.example.demo.models.enums.UsuarioCargo;
import com.example.demo.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private com.example.demo.models.config.SecurityConfig securityConfig;

    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    void deveCriarUsuario() {

        UsuarioRequestDTO dto = new UsuarioRequestDTO();
        dto.setNome("Wesia");
        dto.setEmail("wesia@email.com");
        dto.setSenha("123456");
        dto.setCargo(UsuarioCargo.ADMINISTRADOR);

        Usuario usuarioSalvo = new Usuario(
                1L,
                "Wesia",
                "wesia@email.com",
                UsuarioCargo.ADMINISTRADOR,
                "senha-criptografada"
        );

        when(securityConfig.passwordEncoder().encode(any()))
                .thenReturn("senha-criptografada");

        when(usuarioRepository.save(any(Usuario.class)))
                .thenReturn(usuarioSalvo);

        UsuarioResponseDTO response = usuarioService.criarUsuario(dto);

        assertNotNull(response);
    }
}