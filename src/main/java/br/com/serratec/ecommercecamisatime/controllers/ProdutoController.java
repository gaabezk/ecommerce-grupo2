package br.com.serratec.ecommercecamisatime.controllers;

import br.com.serratec.ecommercecamisatime.exceptions.IdNotFoundException;
import br.com.serratec.ecommercecamisatime.exceptions.ProdutoExistentException;
import br.com.serratec.ecommercecamisatime.models.Imagem;
import br.com.serratec.ecommercecamisatime.models.Produto;
import br.com.serratec.ecommercecamisatime.modelsDTO.ProdutoDTO;
import br.com.serratec.ecommercecamisatime.services.ImagemService;
import br.com.serratec.ecommercecamisatime.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	ImagemService imagemService;
	@Autowired
	ProdutoService produtoService;

	// METODO 1
	/*
	 * @GetMapping public List<Produto> listar() { return
	 * produtoService.listarProdutos(); }
	 */

	// METODO 2
	@GetMapping
	public ResponseEntity<List<Produto>> getAll() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Lista de Produtos", "Segue a lista de produtos");
		return new ResponseEntity<List<Produto>>(produtoService.listar(), headers, HttpStatus.valueOf(202));
	}

	@GetMapping("/{id}/imagem")
	public ResponseEntity<byte[]> getImagem(@PathVariable Integer id) throws IdNotFoundException {
		Imagem imagem = imagemService.getImagem(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-type", imagem.getMimetype());
		headers.add("content-lenght", String.valueOf(imagem.getDados().length));
		return new ResponseEntity<>(imagem.getDados(),headers, HttpStatus.OK);
	}

	@PostMapping("/{categoria}")
	public ResponseEntity<ProdutoDTO> insert(@RequestPart ProdutoDTO produtoDTO, @PathVariable String categoria, @RequestParam MultipartFile file) throws ProdutoExistentException, IOException {
		produtoService.criar(produtoDTO,categoria,file);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Inserir produto", "Insere um produto e retorna ele");
		return new ResponseEntity<>(produtoDTO, headers, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public Produto get(@PathVariable Integer id) throws IdNotFoundException {
		return produtoService.getProdutoDTO(id);
	}
}
