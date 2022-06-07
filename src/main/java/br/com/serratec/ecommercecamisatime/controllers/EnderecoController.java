package br.com.serratec.ecommercecamisatime.controllers;

import br.com.serratec.ecommercecamisatime.exceptions.CpfNonexistentException;
import br.com.serratec.ecommercecamisatime.exceptions.EnderecoNonexistentException;
import br.com.serratec.ecommercecamisatime.exceptions.IdNotFoundException;
import br.com.serratec.ecommercecamisatime.models.Endereco;
import br.com.serratec.ecommercecamisatime.modelsDTO.EnderecoDTO;
import br.com.serratec.ecommercecamisatime.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	EnderecoService enderecoService;

	@GetMapping
	public List<Endereco> getAll() {
		return enderecoService.findAll();
	}

	@GetMapping("/{cep}/{numero}")
	public Endereco getById(@PathVariable String cep, @PathVariable String numero) throws EnderecoNonexistentException {
		return enderecoService.findByEndereco(cep, numero);
	}

	@PostMapping
	public Endereco create(@RequestBody EnderecoDTO endereco) throws CpfNonexistentException {
		return enderecoService.create(endereco);
	}

	@PutMapping("/{cep}/{numero}")
	public ResponseEntity<Endereco> alterar(@Valid @RequestBody EnderecoDTO enderecoDTO, @PathVariable String cep, @PathVariable String numero)
			throws EnderecoNonexistentException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Alterar endereco", "Altera um endereco e retorna ele");
		return new ResponseEntity<>(enderecoService.alterar(enderecoDTO, cep, numero), headers, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{cep}/{numero}")
	public ResponseEntity<String> deletar(@Valid @PathVariable String cep, @PathVariable String numero) throws EnderecoNonexistentException {
		enderecoService.deletar(cep, numero);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Deletar endereco", "Deleta um endereco");
		return new ResponseEntity<>("Endereco deletado!", headers, HttpStatus.valueOf(202));
	}
}
