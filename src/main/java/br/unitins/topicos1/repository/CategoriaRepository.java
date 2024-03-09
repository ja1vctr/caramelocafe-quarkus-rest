package br.unitins.topicos1.repository;

import br.unitins.topicos1.model.Categoria;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.List;

public class CategoriaRepository implements PanacheRepository<Categoria> {
    public List<Categoria> findByNome(String nome){
        return find("UPPER(nome) LIKE ?1", "%"+ nome.toUpperCase()+"%").list();
    }
}
