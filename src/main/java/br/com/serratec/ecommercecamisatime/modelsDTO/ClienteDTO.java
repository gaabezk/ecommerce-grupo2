package br.com.serratec.ecommercecamisatime.modelsDTO;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import br.com.serratec.ecommercecamisatime.models.Cliente;
import br.com.serratec.ecommercecamisatime.models.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ClienteDTO {


	private String nome;
	private String cpf;
	private String telefone;
	private LocalDate dataNascimento;


	private String email;
	private String username;
	private String senha;
	@JsonIgnore
	private String role;
	@JsonIgnore
	private Usuario usuario;


	public ClienteDTO() {
	}

	public ClienteDTO(String nome, String cpf, String telefone, Usuario usuario, LocalDate dataNascimento/*, EnderecoDTO enderecoDto*/) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.usuario = usuario;
	}

	public ClienteDTO(@NotNull Cliente cliente) {
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.telefone = cliente.getTelefone();
		this.dataNascimento = cliente.getDataNascimento();
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
}
