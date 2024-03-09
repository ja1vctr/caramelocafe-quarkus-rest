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
    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;
    @Column(length = 60, nullable = false)
    private String descricao;
    @Column(nullable = false)
    private Double valorDoProduto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
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
