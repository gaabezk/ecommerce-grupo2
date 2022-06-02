package br.com.serratec.ecommercecamisatime.modelsDTO;

import br.com.serratec.ecommercecamisatime.models.Cliente;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class ClienteDTO {

	@NotNull
	private String nome;
	@CPF
	@NotNull
	private String cpf;
	@NotNull
	private String telefone;
	@NotNull
	private LocalDate dataNascimento;

	public ClienteDTO() {
	}

	public ClienteDTO(String nome, String cpf, String telefone, LocalDate dataNascimento) {

		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
	}

	public ClienteDTO(Cliente cliente) {
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
}
