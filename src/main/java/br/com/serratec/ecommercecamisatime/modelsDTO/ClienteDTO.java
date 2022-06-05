package br.com.serratec.ecommercecamisatime.modelsDTO;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import br.com.serratec.ecommercecamisatime.models.Cliente;

public class ClienteDTO {


	private String nome;
	private String cpf;
	private String telefone;
	private LocalDate dataNascimento;


	private String email;
	private String username;
	private String senha;
	private String role;



	//EnderecoDTO enderecoDto = new EnderecoDTO();

	public ClienteDTO() {
	}

	public ClienteDTO(String nome, String cpf, String telefone, LocalDate dataNascimento/*, EnderecoDTO enderecoDto*/) {

		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		/*this.enderecoDto = enderecoDto;*/
	}

	public ClienteDTO(@NotNull Cliente cliente) {
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.telefone = cliente.getTelefone();
		this.dataNascimento = cliente.getDataNascimento();
	}

/*	public EnderecoDTO getEnderecoDto() {
		return enderecoDto;
	}

	public void setEnderecoDto(EnderecoDTO enderecoDto) {
		this.enderecoDto = enderecoDto;
	}*/

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
