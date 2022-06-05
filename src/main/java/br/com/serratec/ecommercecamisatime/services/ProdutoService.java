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

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepositorio produtoRepositorio;
	@Autowired
	CategoriaRepositorio categoriaRepositorio;

	public List<Produto> listar() {
		return produtoRepositorio.findAll();
	}

	public Produto listarPorId(Integer id) throws IdNotFoundException {
		Optional<Produto> optional = produtoRepositorio.findById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException();
		}
		return optional.get();
	}
	public void verificar(String nome) throws ProdutoExistentException{
		Optional<Produto> optional = produtoRepositorio.findByNome(nome);
		if(optional.isPresent()) {
			throw new ProdutoExistentException();
		}
	}
	public Produto criar(ProdutoDTO produtoDTO,String categoria) throws ProdutoExistentException {
		verificar(produtoDTO.getNome());
		Optional<Categoria> optional = categoriaRepositorio.findByNome(categoria);

		Produto newProduto = new Produto(produtoDTO);

		newProduto.setCategoria(optional.get());

		return produtoRepositorio.save(newProduto);
	}
	
	public Produto alterar(Produto produto) throws ProdutoNonexistentException {
		Optional<Produto> optional = produtoRepositorio.findByNome(produto.getNome());
		if(optional.isEmpty()){
			throw new ProdutoNonexistentException();
		}
		Produto oldCategoria = optional.get();
		
		if (produto.getNome() != null) {
			oldCategoria.setNome(produto.getNome());
		}
		if (produto.getDescricao() != null) {
			oldCategoria.setDescricao(produto.getDescricao());
		}
		if (produto.getTamanho() != null) {
			oldCategoria.setTamanho(produto.getTamanho());
		}
		if (produto.getGenero() != null) {
			oldCategoria.setGenero(produto.getGenero());
		}
		if (produto.getQuantidadeEstoque() != null) {
			oldCategoria.setQuantidadeEstoque(produto.getQuantidadeEstoque());
		}
		if (produto.getValor() != null) {
			oldCategoria.setValor(produto.getValor());
		}
		
		return produtoRepositorio.save(oldCategoria);

	}
}
