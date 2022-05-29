package br.com.serratec.ecomercecamisatime.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clientId;

    @OneToMany//TODO TROCAR TMB
    private List<Endereco> endereco;
    @Embedded
    private Usuario usuario;
}