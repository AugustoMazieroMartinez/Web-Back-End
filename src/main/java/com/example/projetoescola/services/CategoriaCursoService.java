package com.example.projetoescola.services;

import java.util.List;

import com.example.projetoescola.dto.CategoriaDTO;



public interface CategoriaCursoService {
    CategoriaDTO salvar(CategoriaDTO categ);
    List<CategoriaDTO> obterTodos();
}
