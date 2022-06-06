package br.com.serratec.ecommercecamisatime.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(name = "email")
    private String email;
    @NotNull
    @Column(name = "username")
    private String username;
    @NotNull
    @Column(name = "senha")
    private String senha;
    @NotNull
    @Column(name = "role")
    private String role;

    @JsonIgnore
    @OneToOne
    private Cliente cliente;
    @JsonIgnore
    @OneToOne
    private Funcionario funcionario;

    public Usuario() {
    }

    public Usuario(Integer id, String email, String username, String senha, String role, Cliente cliente, Funcionario funcionario) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.senha = senha;
        this.role = role;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

}
