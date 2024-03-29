package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.ProdutoDTO;
import br.unitins.topicos1.model.Produto;
import br.unitins.topicos1.repository.CategoriaRepository;
import br.unitins.topicos1.repository.ProdutoRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/produtos")
public class ProdutoResource {
    @Inject
    public ProdutoRepository produtoRepository;
    @Inject
    public CategoriaRepository categoriaRepository;
    @GET
    public List<Produto> findAll(){
        return produtoRepository.listAll();
    }
    @GET
    @Path("/{id}")
    public Produto findById(@PathParam("id") Long id){
        return produtoRepository.findById(id);
    }
    @GET
    @Path("/search/nome/{nome}")
    public List<Produto> findByNome(@PathParam("nome") String nome){
        return produtoRepository.findByNome(nome);
    }
    @GET
    @Path("/search/nome/{codigo}")
    public List<Produto> findByCodigoProduto(@PathParam("codigo") String codigo){
        return produtoRepository.findByCodigoProduto(codigo);
    }
    @POST
    @Transactional
    public Produto create (Produto produto){
        produtoRepository.persist(produto);
        return produto;
    }
    @PUT
    @Transactional
    @Path("/{id}")
    public void updateGeral(@PathParam("id") Long id, ProdutoDTO dtoProduto){
        Produto produto = produtoRepository.findById(id);
        produto.setCodigoProduto(dtoProduto.codigoProduto());
        produto.setNome(dtoProduto.nome());
        produto.setCategoria(categoriaRepository.findById(dtoProduto.idCategoria()));
        produto.setDescricao(dtoProduto.descricao());
        produto.setValorDoProduto(dtoProduto.valorDoProduto());
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void delete(@PathParam("id") Long id){
        produtoRepository.deleteById(id);
    }
}
