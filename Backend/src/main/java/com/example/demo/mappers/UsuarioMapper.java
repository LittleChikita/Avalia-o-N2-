package com.example.demo.mappers;

import com.example.demo.dtos.UsuarioRequestDTO;
import com.example.demo.dtos.UsuarioResponseDTO;
import com.example.demo.models.entities.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapper {

    // RequestDTO → Entity
    public static Usuario toEntity(UsuarioRequestDTO dto) {
        if (dto == null) return null;

        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setCargo(dto.getCargo());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());

        return usuario;
    }

    // Entity → ResponseDTO
    public static UsuarioResponseDTO toDTO(Usuario usuario) {
        if (usuario == null) return null;

        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setCargo(usuario.getCargo());
        dto.setEmail(usuario.getEmail());

        return dto;
    }

    // Atualizar entidade existente a partir do DTO
    public static void updateEntity(Usuario usuario, UsuarioRequestDTO dto) {
        if (usuario == null || dto == null) return;

        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setCargo(dto.getCargo());
    }


    // Lista de entidades → Lista de DTO
    public static List<UsuarioResponseDTO> toDTOList(List<Usuario> usuarios) {
        if (usuarios == null) return null;

        return usuarios.stream()
                .map(UsuarioMapper::toDTO)
                .collect(Collectors.toList());
    }
}
