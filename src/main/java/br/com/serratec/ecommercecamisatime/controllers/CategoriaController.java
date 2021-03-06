package br.com.serratec.ecommercecamisatime.controllers;

import java.util.List;

import javax.validation.Valid;

import br.com.serratec.ecommercecamisatime.exceptions.CategoriaNonexistentException;
import br.com.serratec.ecommercecamisatime.exceptions.CpfNonexistentException;
import br.com.serratec.ecommercecamisatime.modelsDTO.CategoriaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.serratec.ecommercecamisatime.exceptions.CategoriaExistentException;
import br.com.serratec.ecommercecamisatime.models.Categoria;
import br.com.serratec.ecommercecamisatime.services.CategoriaService;
@CrossOrigin
@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	CategoriaService categoriaService;

	@GetMapping
	public ResponseEntity <List<Categoria>> getAll(){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Lista de Categorias", "Retorna uma lista de categorias");
		return new ResponseEntity <List <Categoria>>(categoriaService.listar(),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("{nome}")
	public ResponseEntity <Categoria> getByNome(@PathVariable String nome) throws CategoriaNonexistentException{
		HttpHeaders headers = new HttpHeaders();
		headers.add("Lista de Categorias", "Retorna uma lista de categorias");
		return new ResponseEntity <Categoria>(categoriaService.listarPorNome(nome),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/{cpf}")
	public ResponseEntity<Categoria> cadastro(@Valid @RequestBody Categoria categoria, @PathVariable String cpf) throws CategoriaExistentException, CpfNonexistentException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Inserir categoria", "Insere uma categoria e retorna ela");
		return new ResponseEntity<>(categoriaService.criar(categoria,cpf), headers, HttpStatus.CREATED);
	}

	@PutMapping("/{nome}")
	public ResponseEntity<Categoria> alterar(@Valid @RequestBody CategoriaDTO categoria, @PathVariable String nome) throws CategoriaNonexistentException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Alterar categoria", "Altera uma categoria e retorna ela");
		return new ResponseEntity<>(categoriaService.alterar(categoria,nome), headers, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{nome}")
	public ResponseEntity<String> deletar(@Valid @PathVariable String nome) throws CategoriaNonexistentException {
		categoriaService.deletar(nome);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Deletar categoria", "Deleta uma categoria");
		return new ResponseEntity<>("deletado!",headers, HttpStatus.valueOf(202));
	}
	
}
