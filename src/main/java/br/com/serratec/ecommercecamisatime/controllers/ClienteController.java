package br.com.serratec.ecommercecamisatime.controllers;

import java.util.List;

import br.com.serratec.ecommercecamisatime.exceptions.CategoriaNonexistentException;
import br.com.serratec.ecommercecamisatime.exceptions.CpfExistentException;
import br.com.serratec.ecommercecamisatime.exceptions.CpfNonexistentException;
import br.com.serratec.ecommercecamisatime.modelsDTO.CategoriaDTO;
import br.com.serratec.ecommercecamisatime.modelsDTO.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.serratec.ecommercecamisatime.exceptions.IdNotFoundException;
import br.com.serratec.ecommercecamisatime.models.Categoria;
import br.com.serratec.ecommercecamisatime.models.Cliente;
import br.com.serratec.ecommercecamisatime.services.ClienteService;

import javax.validation.Valid;

@RestController
@RequestMapping("/Cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@GetMapping
	public ResponseEntity<List<Cliente>> getAll() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Lista de Clientes", "Segue a lista de clientes");
		return new ResponseEntity<List<Cliente>>(clienteService.listarClientes(), headers, HttpStatus.valueOf(202));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getById(@Valid @PathVariable Integer id) throws IdNotFoundException {
		return new ResponseEntity<Cliente>(clienteService.listarPorId(id), HttpStatus.FOUND);
	}

	@PostMapping
	public ResponseEntity<Cliente> cadastro(@Valid @RequestBody ClienteDTO clienteDTO) throws CpfExistentException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Inserir cliente", "Insere um cliente e retorna ele");
		return new ResponseEntity<>(clienteService.cadastro(clienteDTO), headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{cpf}")
	public ResponseEntity<Cliente> alterar(@Valid @RequestBody ClienteDTO clienteDTO, @PathVariable String cpf) throws CpfNonexistentException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Alterar cliente", "Altera um cliente e retorna ele");
		return new ResponseEntity<>(clienteService.alterar(clienteDTO,cpf), headers, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping
	public ResponseEntity<String> deletar(@Valid @RequestBody String cpf) throws CpfNonexistentException {
		clienteService.deletar(cpf);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Deletar cliente", "Deleta um cliente");
		return new ResponseEntity<>("Cliente deletado!",headers, HttpStatus.valueOf(202));
	}
}
