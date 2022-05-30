package br.com.serratec.ecommercecamisatime.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cliente{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clientId;

    @Embedded
    private Usuario usuario;
    @ManyToMany(mappedBy = "clienteList")
    private List<Endereco> enderecoList;

    @OneToMany
    private List<Pedido> pedido;
}
