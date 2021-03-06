package br.com.serratec.ecommercecamisatime.controllers;

import br.com.serratec.ecommercecamisatime.exceptions.CpfNonexistentException;
import br.com.serratec.ecommercecamisatime.exceptions.IdNotFoundException;
import br.com.serratec.ecommercecamisatime.exceptions.ProdutoExistentException;
import br.com.serratec.ecommercecamisatime.exceptions.ProdutoNonexistentException;
import br.com.serratec.ecommercecamisatime.models.Funcionario;
import br.com.serratec.ecommercecamisatime.models.Imagem;
import br.com.serratec.ecommercecamisatime.models.Produto;
import br.com.serratec.ecommercecamisatime.modelsDTO.ProdutoDTO;
import br.com.serratec.ecommercecamisatime.repositorios.FuncionarioRepositorio;
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
import java.util.Optional;

import javax.validation.Valid;
@CrossOrigin
@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	FuncionarioRepositorio funcionarioRepositorio;
	@Autowired
	ImagemService imagemService;
	@Autowired
	ProdutoService produtoService;

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
		return new ResponseEntity<>(imagem.getDados(), headers, HttpStatus.OK);
	}

	@PostMapping("/{categoria}/{cpf}")
	public ResponseEntity<ProdutoDTO> insert(@RequestPart ProdutoDTO produtoDTO, @PathVariable String categoria, @PathVariable String cpf,
			@RequestParam MultipartFile file) throws IOException, CpfNonexistentException {
		produtoService.criar(produtoDTO, categoria, file,cpf);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Inserir produto", "Insere um produto e retorna ele");
		return new ResponseEntity<>(produtoDTO, headers, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public Produto get(@PathVariable Integer id) throws IdNotFoundException {
		return produtoService.getProdutoDTO(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Produto> alterar(@Valid @RequestBody ProdutoDTO produtoDTO, @PathVariable Integer id)
			throws ProdutoNonexistentException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Alterar produto", "Altera um produto e retorna ele");
		return new ResponseEntity<>(produtoService.alterar(produtoDTO, id), headers, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletar(@Valid @PathVariable Integer id) throws ProdutoNonexistentException {
		produtoService.deletar(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Deletar produto", "Deleta um produto");
		return new ResponseEntity<>("Produto deletado!", headers, HttpStatus.valueOf(202));
	}
}
