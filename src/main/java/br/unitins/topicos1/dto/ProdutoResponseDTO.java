package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Categoria;
import br.unitins.topicos1.model.Produto;

public record ProdutoResponseDTO(
        Long id,
        String codigoProduto,
        String nome,
        CategoriaResponseDTO categoria,
        String descricao,
        Double valorDoProduto
) {
    public static ProdutoResponseDTO valueOf(Produto produto){
        return new ProdutoResponseDTO(
                produto.getId(),
                produto.getCodigoProduto(),
                produto.getNome(),
                CategoriaResponseDTO.valueOf(produto.getCategoria()),
                produto.getDescricao(),
                produto.getValorDoProduto()
        );

    }
}
