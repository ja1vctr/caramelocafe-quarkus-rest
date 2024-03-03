package br.unitins.topicos1.model;

import jakarta.persistence.*;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20, nullable = false)
    private String codigoProduto;
    @Column(length = 60, nullable = false)
    private String nome;
    @Column(length = 60, nullable = false)
    private String categoria;
    @Column(length = 60, nullable = false)
    private String descricao;
    @Column(nullable = false)
    private Double valorDoProduto;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorDoProduto() {
        return valorDoProduto;
    }

    public void setValorDoProduto(Double valorDoProduto) {
        this.valorDoProduto = valorDoProduto;
    }
}
