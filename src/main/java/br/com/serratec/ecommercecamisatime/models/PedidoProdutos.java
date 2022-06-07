package br.com.serratec.ecommercecamisatime.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class PedidoProdutos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "preco")
    private Double preco;

    public PedidoProdutos() {
    }

    public PedidoProdutos(Integer id, Produto produto, Pedido pedido, Integer quantidade, Double preco) {
        this.id = id;
        this.produto = produto;
        this.pedido = pedido;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "ProdutosPedidos{" +
                "id=" + id +
                ", produto=" + produto +
                ", pedido=" + pedido +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                '}';
    }
}
