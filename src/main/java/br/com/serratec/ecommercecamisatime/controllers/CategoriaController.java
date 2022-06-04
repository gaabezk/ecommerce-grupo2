package br.com.serratec.ecommercecamisatime.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.ecommercecamisatime.exceptions.CategoriaExistenteException;
import br.com.serratec.ecommercecamisatime.models.Categoria;
import br.com.serratec.ecommercecamisatime.services.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	CategoriaService categoriaService;
	
	
	@GetMapping
	public ResponseEntity <List<Categoria>> getAll(){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Lista de Categorias", "Retorna uma lista de categorias");
		return new ResponseEntity <List <Categoria>>(categoriaService.listarCategoria(),HttpStatus.ACCEPTED);
	}
	
	@PostMapping
	public ResponseEntity<Categoria> cadastro(@Valid @RequestBody Categoria categoria) throws CategoriaExistenteException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Inserir categoria", "Insere uma categoria e retorna ela");
		return new ResponseEntity<>(categoriaService.criaCategoria(categoria), headers, HttpStatus.CREATED);
	}
	
}
