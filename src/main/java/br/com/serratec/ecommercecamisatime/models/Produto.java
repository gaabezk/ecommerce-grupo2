package br.com.serratec.ecommercecamisatime.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Size(max = 80)
    private String nome,descricao,tamanho,time,genero;
    @NotNull
    private Integer quantidade;
    @NotNull
    private Double valor;
    @JsonIgnore
    @ManyToMany
    private List<Pedido> pedidosProduto;
    public Produto() {
    }
    public Produto(Integer id, String nome, String descricao, String tamanho, String time, String genero, Integer quantidade, Double valor, List<Pedido> pedidosProduto) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tamanho = tamanho;
        this.time = time;
        this.genero = genero;
        this.quantidade = quantidade;
        this.valor = valor;
        this.pedidosProduto = pedidosProduto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public List<Pedido> getPedidosProduto() {
        return pedidosProduto;
    }
    public void setPedidosProduto(List<Pedido> pedidosProduto) {
        this.pedidosProduto = pedidosProduto;
    }
}
