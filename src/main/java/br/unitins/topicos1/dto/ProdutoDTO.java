package br.unitins.topicos1.dto;

public record ProdutoDTO (
        String codigoProduto,
        String nome,
        Long idCategoria,
        String descricao,
        Double valorDoProduto

    ) {
}
