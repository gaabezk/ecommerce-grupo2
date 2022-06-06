package br.com.serratec.ecommercecamisatime.models;

import br.com.serratec.ecommercecamisatime.modelsDTO.ClienteDTO;
import br.com.serratec.ecommercecamisatime.modelsDTO.FuncionarioDTO;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(name = "nome")
    private String nome;
    @CPF
    @NotNull
    @Column(name = "cpf", unique = true)
    private String cpf;
    @NotNull
    @Column(name = "telefone")
    private String telefone;
    @NotNull
    @Past
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;

    public Funcionario() {
    }

    public Funcionario(Integer id, String nome, String cpf, String telefone, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
    }

    public Funcionario(FuncionarioDTO funcionarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setEmail(funcionarioDTO.getEmail());
        usuario.setUsername(funcionarioDTO.getUsername());
        usuario.setSenha(funcionarioDTO.getSenha());
        usuario.setRole("funcionario");
        usuario.setFuncionario(Funcionario.this);

        this.nome = funcionarioDTO.getNome();
        this.cpf = funcionarioDTO.getCpf();
        this.dataNascimento = funcionarioDTO.getDataNascimento();
        this.telefone = funcionarioDTO.getTelefone();
        this.usuario = usuario;

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
