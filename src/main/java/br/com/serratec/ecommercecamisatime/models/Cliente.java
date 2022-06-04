package br.com.serratec.ecommercecamisatime.models;

import br.com.serratec.ecommercecamisatime.modelsDTO.ClienteDTO;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Cliente {

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
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos;
	@OneToMany(mappedBy = "cliente")
	private List<Endereco> enderecos;

	@OneToOne(cascade = CascadeType.ALL)
	private Usuario usuario;

	public Cliente() {
	}

	public Cliente(Integer id, String nome, String cpf, String telefone, LocalDate dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
	}

	public Cliente(ClienteDTO clienteDTO) {
		this.nome = clienteDTO.getNome();
		this.cpf = clienteDTO.getCpf();
		this.dataNascimento = clienteDTO.getDataNascimento();
		this.telefone = clienteDTO.getTelefone();
		//this.usuario.setRole("cliente");
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
}
