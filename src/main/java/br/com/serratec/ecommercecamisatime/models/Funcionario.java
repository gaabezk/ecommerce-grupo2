package br.com.serratec.ecommercecamisatime.models;

import javax.persistence.*;

@Entity
public class Funcionario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


}
