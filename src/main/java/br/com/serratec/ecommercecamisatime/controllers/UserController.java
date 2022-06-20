package br.com.serratec.ecommercecamisatime.controllers;

import java.util.List;

import br.com.serratec.ecommercecamisatime.exceptions.CpfExistentException;
import br.com.serratec.ecommercecamisatime.exceptions.CpfNonexistentException;
import br.com.serratec.ecommercecamisatime.exceptions.EmailExistentException;
import br.com.serratec.ecommercecamisatime.models.Funcionario;
import br.com.serratec.ecommercecamisatime.modelsDTO.ClienteDTO;
import br.com.serratec.ecommercecamisatime.modelsDTO.FuncionarioDTO;
import br.com.serratec.ecommercecamisatime.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.serratec.ecommercecamisatime.exceptions.IdNotFoundException;
import br.com.serratec.ecommercecamisatime.models.Cliente;
import br.com.serratec.ecommercecamisatime.services.ClienteService;

import javax.validation.Valid;
@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UserController {

	@Autowired
	ClienteService clienteService;

	@Autowired
	FuncionarioService funcionarioService;

	// =================================================CLIENTE==========================================================

	@GetMapping("/cliente")
	public ResponseEntity<List<Cliente>> getAll() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Lista de Clientes", "Segue a lista de clientes");
		return new ResponseEntity<List<Cliente>>(clienteService.listarClientes(), headers, HttpStatus.valueOf(202));
	}

	@GetMapping("/cliente/{cpf}")
	public ResponseEntity<Cliente> getById(@Valid @PathVariable String cpf) throws CpfNonexistentException {
		return new ResponseEntity<Cliente>(clienteService.listarPorCpf(cpf), HttpStatus.FOUND);
	}

	@PostMapping("/cliente")
	public ResponseEntity<Cliente> cadastro(@Valid @RequestBody ClienteDTO clienteDTO)
			throws CpfExistentException, EmailExistentException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Inserir cliente", "Insere um cliente e retorna ele");
		return new ResponseEntity<>(clienteService.cadastro(clienteDTO), headers, HttpStatus.CREATED);
	}

	@PutMapping("/cliente/{cpf}")
	public ResponseEntity<Cliente> alterar(@Valid @RequestBody ClienteDTO clienteDTO, @PathVariable String cpf)
			throws CpfNonexistentException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Alterar cliente", "Altera um cliente e retorna ele");
		return new ResponseEntity<>(clienteService.alterar(clienteDTO, cpf), headers, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/cliente/{cpf}")
	public ResponseEntity<String> deletar(@Valid @PathVariable String cpf) throws CpfNonexistentException {
		clienteService.deletar(cpf);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Deletar cliente", "Deleta um cliente");
		return new ResponseEntity<>("Cliente deletado!", headers, HttpStatus.valueOf(202));
	}

	// ==============================================FUNCIONARIO=========================================================

	@GetMapping("/funcionario")
	public ResponseEntity<List<Funcionario>> getAllF() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Lista de Funcionarios", "Segue a lista de Funcionarios");
		return new ResponseEntity<List<Funcionario>>(funcionarioService.listar(), headers, HttpStatus.valueOf(202));
	}

	@GetMapping("/funcionario/{id}")
	public ResponseEntity<Funcionario> getByIdF(@Valid @PathVariable Integer id) throws IdNotFoundException {
		return new ResponseEntity<Funcionario>(funcionarioService.listarPorId(id), HttpStatus.FOUND);
	}

	@PostMapping("/funcionario/{cpf}")
	public ResponseEntity<Funcionario> cadastroF(@Valid @RequestBody FuncionarioDTO funcionarioDTO, @PathVariable String cpf)
			throws CpfExistentException, EmailExistentException, CpfNonexistentException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Inserir Funcionario", "Insere um Funcionarios e retorna ele");
		return new ResponseEntity<>(funcionarioService.cadastro(funcionarioDTO,cpf), headers, HttpStatus.CREATED);
	}

	@PutMapping("/funcionario/{cpf}")
	public ResponseEntity<Funcionario> alterarF(@Valid @RequestBody FuncionarioDTO funcionarioDTO,
			@PathVariable String cpf) throws CpfNonexistentException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Alterar Funcionario", "Altera um Funcionarios e retorna ele");
		return new ResponseEntity<>(funcionarioService.alterar(funcionarioDTO, cpf), headers, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/funcionario/{cpf}")
	public ResponseEntity<String> deletarF(@Valid @PathVariable String cpf) throws CpfNonexistentException {
		funcionarioService.deletar(cpf);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Deletar Funcionario", "Deleta um Funcionario");
		return new ResponseEntity<>("Funcionario deletado!", headers, HttpStatus.valueOf(202));
	}

}
