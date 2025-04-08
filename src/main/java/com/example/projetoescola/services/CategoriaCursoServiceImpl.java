package com.example.projetoescola.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.projetoescola.dto.CategoriaDTO;
import com.example.projetoescola.models.CategoriaCurso;
import com.example.projetoescola.repositories.CategoriaCursoRepository;

@Service
public class CategoriaCursoServiceImpl implements CategoriaCursoService {

    @Autowired
    private CategoriaCursoRepository categoriaCursoRepository;

    @Override
    public CategoriaDTO salvar(CategoriaDTO categ) {
        CategoriaCurso categoriaCurso = new CategoriaCurso();
        categoriaCurso.setNome(categ.getNome());

        CategoriaCurso savedCategoria = categoriaCursoRepository.save(categoriaCurso);

        CategoriaDTO categoriaResponse = new CategoriaDTO();
        categoriaResponse.setId(savedCategoria.getId());
        categoriaResponse.setNome(savedCategoria.getNome());
        return categoriaResponse;
    }

    @Override
    public List<CategoriaDTO> obterTodos() {
        return categoriaCursoRepository.findAll().stream()
                .map(categoria -> new CategoriaDTO(categoria.getId(), categoria.getNome()))
                .collect(Collectors.toList());
    }
}
