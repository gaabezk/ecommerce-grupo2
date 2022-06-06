package br.com.serratec.ecommercecamisatime.modelsDTO;

import br.com.serratec.ecommercecamisatime.models.Funcionario;
import org.hibernate.validator.constraints.br.CPF;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class FuncionarioDTO {

    @NotNull
    private String nome;
    @CPF
    @NotNull
    private String cpf;
    @NotNull
    private String telefone;
    @NotNull
    private LocalDate dataNascimento;

    public FuncionarioDTO() {
    }

    public FuncionarioDTO(String nome, String cpf, String telefone, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    public FuncionarioDTO(@NotNull Funcionario funcionario) {
        this.nome = funcionario.getNome();
        this.cpf = funcionario.getCpf();
        this.telefone = funcionario.getTelefone();
        this.dataNascimento = funcionario.getDataNascimento();
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}

