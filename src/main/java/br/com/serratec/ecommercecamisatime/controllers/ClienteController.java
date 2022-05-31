package br.com.serratec.ecommercecamisatime.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.serratec.ecommercecamisatime.exceptions.IdNotFoundException;
import br.com.serratec.ecommercecamisatime.models.Cliente;
import br.com.serratec.ecommercecamisatime.services.ClienteService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@GetMapping
	public ResponseEntity<List<Cliente>> getAll() {
		return new ResponseEntity<List<Cliente>>(clienteService.listarClientes(), HttpStatus.valueOf(202));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getById(@PathVariable Integer id) throws IdNotFoundException {
		return new ResponseEntity<Cliente>(clienteService.listarPorId(id), HttpStatus.FOUND);
	}

	@PostMapping
	public ResponseEntity<Cliente> insert(@RequestBody Cliente cliente) {
		clienteService.insert(cliente);
		return new ResponseEntity<>(cliente, HttpStatus.CREATED);
	}

}
