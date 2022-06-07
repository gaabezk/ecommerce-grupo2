package br.com.serratec.ecommercecamisatime.models;

import br.com.serratec.ecommercecamisatime.modelsDTO.PedidoDTO;
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

    @OneToMany(mappedBy = "pedido")
    private List<ProdutosPedidos> produtosPedidos;

    public Pedido() {
    }

    public Pedido(Integer id, Double valorTotal, LocalDateTime dataPedido, LocalDateTime dataEntrega, String status, Cliente cliente) {
        this.numPedido = gerarNum();

        this.valorTotal = valorTotal;
        this.dataPedido = dataPedido;
        this.dataEntrega = dataEntrega;
        this.status = status;
        this.cliente = cliente;
    }
    public Pedido(PedidoDTO pedidoDTO){
        this.numPedido = gerarNum();
        this.dataPedido = LocalDateTime.now();
        this.status = "pedido criado";

        this.valorTotal = valorTotal;
        this.dataEntrega = dataEntrega;
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

    public List<ProdutosPedidos> getProdutosPedidos() {
        return produtosPedidos;
    }

    public void setProdutosPedidos(List<ProdutosPedidos> produtosPedidos) {
        this.produtosPedidos = produtosPedidos;
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
                ", produtosPedidos=" + produtosPedidos +
                '}';
    }
}
