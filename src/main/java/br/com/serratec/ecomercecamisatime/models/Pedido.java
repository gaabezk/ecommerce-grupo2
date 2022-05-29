package br.com.serratec.ecomercecamisatime.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private LocalDateTime dataHora;

    @OneToMany
    private List<Produto> produtos;

    public Pedido() {
    }
    public Pedido(Integer id, LocalDateTime dataHora, List<Produto> produtos) {
        this.id = id;
        this.dataHora = dataHora;
        this.produtos = produtos;
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
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
