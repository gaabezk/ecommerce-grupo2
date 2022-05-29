package br.com.serratec.ecommercecamisatime.models;

import javax.persistence.*;

@Entity
public class Funcionario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne //TODO TROCAR DPS
    private Endereco endereco;
    @Embedded
    private Usuario usuario;

}
