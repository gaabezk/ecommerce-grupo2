package br.com.serratec.ecomercecamisatime.model;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;

@Embeddable
public class Usuario {

    private String nome;
    @CPF
    private String cpf;
    private String telefone;

    public Usuario() {
    }

    public Usuario(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
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
}
