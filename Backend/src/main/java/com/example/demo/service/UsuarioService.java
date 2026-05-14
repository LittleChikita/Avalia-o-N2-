package com.example.demo.service;

import com.example.demo.dtos.UsuarioRequestDTO;
import com.example.demo.dtos.UsuarioResponseDTO;
import com.example.demo.mappers.UsuarioMapper;
import com.example.demo.models.config.SecurityConfig;
import com.example.demo.models.entities.Usuario;
import com.example.demo.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final SecurityConfig securityConfig;

    public UsuarioService(UsuarioRepository usuarioRepository,
                          SecurityConfig securityConfig) {
        this.usuarioRepository = usuarioRepository;
        this.securityConfig = securityConfig;
    }

    public UsuarioResponseDTO criarUsuario(UsuarioRequestDTO dto) {
        Usuario entity = UsuarioMapper.toEntity(dto);
        entity.setSenha(securityConfig.passwordEncoder().encode(dto.getSenha()));
        Usuario saved = usuarioRepository.save(entity);
        return UsuarioMapper.toDTO(saved);
    }

    public List<UsuarioResponseDTO> listarTodos() {
        return UsuarioMapper.toDTOList(usuarioRepository.findAll());
    }

    public UsuarioResponseDTO encontrarPorId(Long id) {
        Usuario entity = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));
        return UsuarioMapper.toDTO(entity);
    }

    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {
        Usuario entity = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));

        UsuarioMapper.updateEntity(entity, dto);

        if (dto.getSenha() != null && !dto.getSenha().trim().isEmpty()) {
            entity.setSenha(securityConfig.passwordEncoder().encode(dto.getSenha()));
        }

        Usuario updated = usuarioRepository.save(entity);
        return UsuarioMapper.toDTO(updated);
    }

    public void deletar(Long id) {
        if (!usuarioRepository.existsById(id))
            throw new EntityNotFoundException("Usuário não encontrado com ID: " + id);

        usuarioRepository.deleteById(id);
    }
}
