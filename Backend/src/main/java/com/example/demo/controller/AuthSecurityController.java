package com.example.demo.controller;

import com.example.demo.dtos.LoginRequestDTO;
import com.example.demo.dtos.LoginResponseDTO;
import com.example.demo.service.AuthSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthSecurityController {
/*
    @Autowired
    private AuthSecurityService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO dto) {
        LoginResponseDTO resposta = authService.autenticar(dto.getEmail(), dto.getSenha());

        if (!resposta.isAutenticado()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(resposta);
        }

        return ResponseEntity.ok(resposta);
    }

 */
}
