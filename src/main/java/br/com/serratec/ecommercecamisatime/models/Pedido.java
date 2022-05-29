package br.com.serratec.ecommercecamisatime.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private LocalDateTime dataHora;


    @ManyToMany(mappedBy = "pedidosProduto")
    private List<Produto> produtosPedido;

    public Pedido() {
    }
    public Pedido(Integer id, LocalDateTime dataHora, List<Produto> produtos) {
        this.id = id;
        this.dataHora = dataHora;
        this.produtosPedido = produtos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public List<Produto> getProdutos() {
        return produtosPedido;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtosPedido = produtos;
    }
}
