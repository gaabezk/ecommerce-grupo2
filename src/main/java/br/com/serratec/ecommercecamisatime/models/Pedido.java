package br.com.serratec.ecommercecamisatime.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero_pedido")
    private Integer numPedido;

    @Column(name = "valortotal_pedido")
    private Double valorTotal;

    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;

    @Column(name = "data_entrega")
    private LocalDateTime dataEntrega;

    @Column(name = "status")
    private String status;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @JsonIgnore
    @OneToMany(mappedBy = "pedido")
    private List<PedidoProdutos> produtos;

    public Pedido() {
    }

    public Pedido(Integer id, Integer numPedido, Double valorTotal, LocalDateTime dataPedido, LocalDateTime dataEntrega, String status, Cliente cliente, List<PedidoProdutos> produtos) {
        this.id = id;
        this.numPedido = numPedido;
        this.valorTotal = valorTotal;
        this.dataPedido = dataPedido;
        this.dataEntrega = dataEntrega;
        this.status = status;
        this.cliente = cliente;
        this.produtos = produtos;
    }

    public Pedido(Cliente cliente){
        this.numPedido = gerarNum();
        this.valorTotal = 0.0;
        this.dataPedido = LocalDateTime.now();
        this.dataEntrega = LocalDateTime.now().plusDays(15);
        this.status = "Aberto";
        this.cliente = cliente;
    }

    public Integer gerarNum() {
        int min_val = 100000;
        int max_val = 890000;
        Random ran = new Random();
        int x = ran.nextInt(max_val) + min_val;
        return x;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(Integer numPedido) {
        this.numPedido = numPedido;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDateTime dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<PedidoProdutos> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<PedidoProdutos> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", numPedido=" + numPedido +
                ", valorTotal=" + valorTotal +
                ", dataPedido=" + dataPedido +
                ", dataEntrega=" + dataEntrega +
                ", status='" + status + '\'' +
                ", cliente=" + cliente +
                ", produtosPedidos=" + produtos +
                '}';
    }
}
