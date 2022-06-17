package br.com.serratec.ecommercecamisatime.services;

import br.com.serratec.ecommercecamisatime.exceptions.CpfNonexistentException;
import br.com.serratec.ecommercecamisatime.exceptions.IdNotFoundException;
import br.com.serratec.ecommercecamisatime.exceptions.ProdutoExistentException;
import br.com.serratec.ecommercecamisatime.exceptions.ProdutoNonexistentException;
import br.com.serratec.ecommercecamisatime.models.Categoria;
import br.com.serratec.ecommercecamisatime.models.Funcionario;
import br.com.serratec.ecommercecamisatime.models.Produto;
import br.com.serratec.ecommercecamisatime.modelsDTO.ProdutoDTO;
import br.com.serratec.ecommercecamisatime.repositorios.CategoriaRepositorio;
import br.com.serratec.ecommercecamisatime.repositorios.FuncionarioRepositorio;
import br.com.serratec.ecommercecamisatime.repositorios.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

	@Autowired
	FuncionarioRepositorio funcionarioRepositorio;
	@Autowired
	ProdutoRepositorio produtoRepositorio;
	@Autowired
	CategoriaRepositorio categoriaRepositorio;

	@Autowired
	ImagemService imagemService;

	public List<Produto> listar() {
		List<Produto> lista = produtoRepositorio.findAll();
		for (Produto prod: lista ){
			prod.setUrl(imagemService.createUrl(prod.getId()));
		}

		return lista;

	}

	public Produto getProdutoDTO(Integer id) throws IdNotFoundException {
		Produto produto = this.listarPorId(id);
		produto.setUrl(imagemService.createUrl(produto.getId()));
		System.out.println(produto.getUrl());
		return produto;
	}

	public Produto listarPorId(Integer id) throws IdNotFoundException {
		Optional<Produto> optional = produtoRepositorio.findById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException();
		}
		return optional.get();
	}

	public void verificar(String descricao) throws ProdutoExistentException {
		Optional<Produto> optional = produtoRepositorio.findByDescricao(descricao);
		if (optional.isPresent()) {
			throw new ProdutoExistentException();
		}
	}

	public Produto criar(ProdutoDTO produtoDTO, String categoria, MultipartFile file, String cpf)
			throws IOException, CpfNonexistentException {
		Optional<Categoria> optional = categoriaRepositorio.findByNome(categoria);
		Optional<Funcionario> funcionario = funcionarioRepositorio.findByCpf(cpf);
		if (funcionario.isEmpty()){
			throw new CpfNonexistentException();
		}

		Produto newProduto = new Produto(produtoDTO);

		newProduto.setCategoria(optional.get());

		Produto savedProd = produtoRepositorio.save(newProduto);

		imagemService.create(savedProd, file);

		return savedProd;
	}


	public Produto alterar(ProdutoDTO produtoDTO, Integer id) throws ProdutoNonexistentException {
		Optional<Produto> optional = produtoRepositorio.findById(id);
		if (optional.isEmpty()) {
			throw new ProdutoNonexistentException();
		}
		Produto oldProduto = optional.get();

		if (produtoDTO.getNome() != null) {
			oldProduto.setNome(produtoDTO.getNome());
		}
		if (produtoDTO.getTamanho() != null) {
			oldProduto.setTamanho(produtoDTO.getTamanho());
		}
		if (produtoDTO.getDescricao() != null) {
			oldProduto.setDescricao(produtoDTO.getDescricao());
		}
		if (produtoDTO.getValor() != null) {
			oldProduto.setValor(produtoDTO.getValor());
		}
		if (produtoDTO.getGenero() != null) {
			oldProduto.setGenero(produtoDTO.getGenero());
		}
		if (produtoDTO.getQuantidadeEstoque() != null) {
			oldProduto.setQuantidadeEstoque(produtoDTO.getQuantidadeEstoque());
		}
		return produtoRepositorio.save(oldProduto);
	}

	public void deletar(Integer id) throws ProdutoNonexistentException {
		Optional<Produto> optional = produtoRepositorio.findById(id);
		if (optional.isEmpty()) {
			throw new ProdutoNonexistentException();
		}
		produtoRepositorio.delete(optional.get());
	}
}
