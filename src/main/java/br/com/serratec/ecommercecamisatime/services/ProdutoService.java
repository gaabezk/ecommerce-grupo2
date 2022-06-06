package br.com.serratec.ecommercecamisatime.services;

import br.com.serratec.ecommercecamisatime.exceptions.IdNotFoundException;
import br.com.serratec.ecommercecamisatime.exceptions.ProdutoExistentException;
import br.com.serratec.ecommercecamisatime.exceptions.ProdutoNonexistentException;
import br.com.serratec.ecommercecamisatime.models.Categoria;
import br.com.serratec.ecommercecamisatime.models.Produto;
import br.com.serratec.ecommercecamisatime.modelsDTO.ProdutoDTO;
import br.com.serratec.ecommercecamisatime.repositorios.CategoriaRepositorio;
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
	ProdutoRepositorio produtoRepositorio;
	@Autowired
	CategoriaRepositorio categoriaRepositorio;

	@Autowired
	ImagemService imagemService;

	public List<Produto> listar() {
		return produtoRepositorio.findAll();
	}

	public Produto getProdutoDTO(Integer id) throws IdNotFoundException {
		Produto produto = this.listarPorId(id);
		produto.setUrl(imagemService.createUrl(produto.getId()));
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

	public Produto criar(ProdutoDTO produtoDTO, String categoria, MultipartFile file)
			throws ProdutoExistentException, IOException {
		verificar(produtoDTO.getDescricao());
		Optional<Categoria> optional = categoriaRepositorio.findByNome(categoria);

		Produto newProduto = new Produto(produtoDTO);

		newProduto.setCategoria(optional.get());

		Produto savedProd = produtoRepositorio.save(newProduto);

		imagemService.create(savedProd, file);

		return savedProd;
	}

//	public Produto alterar(Produto produto) throws ProdutoNonexistentException {
//		Optional<Produto> optional = produtoRepositorio.findByNome(produto.getNome());
//		if (optional.isEmpty()) {
//			throw new ProdutoNonexistentException();
//		}
//		Produto oldCategoria = optional.get();
//
//		if (produto.getNome() != null) {
//			oldCategoria.setNome(produto.getNome());
//		}
//		if (produto.getDescricao() != null) {
//			oldCategoria.setDescricao(produto.getDescricao());
//		}
//		if (produto.getTamanho() != null) {
//			oldCategoria.setTamanho(produto.getTamanho());
//		}
//		if (produto.getGenero() != null) {
//			oldCategoria.setGenero(produto.getGenero());
//		}
//		if (produto.getQuantidadeEstoque() != null) {
//			oldCategoria.setQuantidadeEstoque(produto.getQuantidadeEstoque());
//		}
//		if (produto.getValor() != null) {
//			oldCategoria.setValor(produto.getValor());
//		}
//
//		return produtoRepositorio.save(oldCategoria);
//
//	}

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
