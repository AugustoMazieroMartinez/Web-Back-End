package com.example.projetoescola.services;

import java.util.List;

import com.example.projetoescola.dto.CursoDTO;
import com.example.projetoescola.dto.CursoRequestDTO;

public interface CursoService {
    CursoDTO salvar(CursoRequestDTO cursoDTO);
    List<CursoDTO> obterTodos();
}
