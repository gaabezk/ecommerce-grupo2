package br.com.serratec.ecommercecamisatime.models;

import javax.persistence.*;

@Entity
public class ProdutosPedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "produto_id",referencedColumnName = "id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "pedido_id",referencedColumnName = "id")
    private Pedido pedido;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "preco")
    private Double preco;

    public ProdutosPedidos() {
    }

    public ProdutosPedidos(Integer id, Produto produto, Pedido pedido, Integer quantidade, Double preco) {
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

    public Double getPreço() {
        return preco;
    }

    public void setPreço(Double preço) {
        this.preco = preço;
    }
}
