package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.CategoriaDTO;
import br.unitins.topicos1.model.Categoria;
import br.unitins.topicos1.repository.CategoriaRepository;
import br.unitins.topicos1.repository.CategoriaRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/Categorias")
public class CategoriaResource {
    @Inject
    public CategoriaRepository categoriaRepository;
    @GET
    public List<Categoria> findAll(){
        return categoriaRepository.listAll();
    }
    @GET
    @Path("/{id}")
    public Categoria findById(@PathParam("id") Long id){
        return categoriaRepository.findById(id);
    }
    @GET
    @Path("/search/nome/{nome}")
    public List<Categoria> findByNome(@PathParam("nome") String nome){
        return categoriaRepository.findByNome(nome);
    }

    @POST
    @Transactional
    public Categoria create (Categoria categoria){
        categoriaRepository.persist(categoria);
        return categoria;
    }
    @PUT
    @Transactional
    @Path("/{id}")
    public void updateGeral(@PathParam("id") Long id, CategoriaDTO dtoCategoria){
        Categoria categoria = categoriaRepository.findById(id);
        categoria.setNome(dtoCategoria.nome());
        categoria.setDescricao(dtoCategoria.descricao());
    }
    @DELETE
    @Transactional
    @Path("/{id}")
    public void delete(@PathParam("id") Long id){
        categoriaRepository.deleteById(id);
    }
}
