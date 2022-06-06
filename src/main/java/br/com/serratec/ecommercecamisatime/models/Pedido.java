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
    private Long valorTotal;

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

    public Pedido(Integer id, Long valorTotal, LocalDateTime dataPedido, LocalDateTime dataEntrega, String status, Cliente cliente) {
        this.id = id;
        this.numPedido = gerarNum();
        this.valorTotal = valorTotal;
        this.dataPedido = dataPedido;
        this.dataEntrega = dataEntrega;
        this.status = status;
        this.cliente = cliente;
    }

    public Integer gerarNum() {
        int min_val = 100000;
        int max_val = 890000;
        Random ran = new Random();
        int x = ran.nextInt(max_val) + min_val;
        return x;
    }

    public void setValorTotal(Double valorTotal) {
    }
}
