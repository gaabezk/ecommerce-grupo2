package br.com.serratec.ecomercecamisatime.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cliente{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clientId;

    @Embedded
    private Usuario usuario;

    @OneToMany//TODO TROCAR TMB
    private List<Endereco> endereco;

    @OneToMany
    private List<Pedido> pedido;
}
