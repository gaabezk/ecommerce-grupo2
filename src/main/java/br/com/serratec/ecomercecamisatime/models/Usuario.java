package br.com.serratec.ecomercecamisatime.models;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;

@Embeddable
public class Usuario {

    private String nome;
    @CPF
    private String cpf;
    private String telefone;
    private String username;
    private String password;
    public Usuario() {
    }

    public Usuario(String nome, String cpf, String telefone,String username, String password) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.username = username;
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
