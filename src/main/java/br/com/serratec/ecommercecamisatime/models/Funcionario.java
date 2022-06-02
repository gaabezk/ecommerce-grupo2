package br.com.serratec.ecommercecamisatime.models;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
public class Funcionario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf", unique = true)
    @CPF
    private String cpf;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "data_nascimento")
    @Past
    private LocalDate dataNascimento;




}
