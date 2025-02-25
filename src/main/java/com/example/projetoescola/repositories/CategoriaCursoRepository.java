package com.example.projetoescola.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projetoescola.models.CategoriaCurso;
import com.example.projetoescola.models.Curso;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class CategoriaCursoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public CategoriaCurso inserir(CategoriaCurso categoriaCurso) {
        return entityManager.merge(categoriaCurso);
    }

    public List<CategoriaCurso> obterTodos(){
        return entityManager.createQuery("from CategoriaCurso", CategoriaCurso.class).getResultList();
    }

    public List<CategoriaCurso> obterPorNome(String nome){
        return entityManager.createQuery("from CategoriaCurso where nome = :nome", CategoriaCurso.class)
            .setParameter("nome", nome)
            .getResultList();
    }
}
