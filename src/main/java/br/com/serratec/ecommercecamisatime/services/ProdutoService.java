package br.com.serratec.ecommercecamisatime.services;

import br.com.serratec.ecommercecamisatime.exceptions.CategoriaExistentException;
import br.com.serratec.ecommercecamisatime.exceptions.CategoriaNonexistentException;
import br.com.serratec.ecommercecamisatime.exceptions.IdNotFoundException;
import br.com.serratec.ecommercecamisatime.exceptions.ProdutoExistentException;
import br.com.serratec.ecommercecamisatime.exceptions.ProdutoNonexistentException;
import br.com.serratec.ecommercecamisatime.models.Categoria;
import br.com.serratec.ecommercecamisatime.models.Pedido;
import br.com.serratec.ecommercecamisatime.models.Produto;
import br.com.serratec.ecommercecamisatime.modelsDTO.CategoriaDTO;
import br.com.serratec.ecommercecamisatime.repositorios.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepositorio produtoRepositorio;

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
	
	public void verificar(Integer id) throws ProdutoExistentException{
		Optional<Produto> optional = produtoRepositorio.findById(id);
		if(optional.isPresent()) {
			throw new ProdutoExistentException();
		}
	}

	public Produto criar(Produto produto) throws ProdutoExistentException {
		verificar(produto.getId());
		return produtoRepositorio.save(produto);
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
		if (produto.getQuantidade() != null) {
			oldCategoria.setQuantidade(produto.getQuantidade());
		}
		if (produto.getValor() != null) {
			oldCategoria.setValor(produto.getValor());
		}
		
		return produtoRepositorio.save(oldCategoria);

	}
}
