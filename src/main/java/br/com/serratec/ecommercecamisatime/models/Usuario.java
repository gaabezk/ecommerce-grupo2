package br.com.serratec.ecommercecamisatime.models;

import javax.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "senha")
    private String senha;

    @Column(name = "role")
    private String role;



}
