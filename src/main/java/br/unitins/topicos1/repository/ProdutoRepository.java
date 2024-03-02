package br.unitins.topicos1.repository;

import br.unitins.topicos1.model.Produto;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ProdutoRepository implements PanacheRepository<Produto> {
    public List<Produto> findByNome(String nome){
        return find("nome LIKE ?1","%"+ nome+"%").list();
    }

    public List<Produto> findByCodigoProduto(String codigoProduto){
        return find("nome LIKE ?1","%"+ codigoProduto+"%").list();
    }
}
