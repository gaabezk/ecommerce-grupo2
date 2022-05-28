package br.com.serratec.ecomercecamisatime.model;

import javax.persistence.*;

@Entity
public class Funcionario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Endereco endereco;
    @Embedded
    private Usuario usuario;

}
