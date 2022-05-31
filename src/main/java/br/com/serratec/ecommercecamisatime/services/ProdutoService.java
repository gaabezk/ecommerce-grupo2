package br.com.serratec.ecommercecamisatime.services;

import br.com.serratec.ecommercecamisatime.exceptions.IdNotFoundException;
import br.com.serratec.ecommercecamisatime.models.Produto;
import br.com.serratec.ecommercecamisatime.repositorios.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepositorio produtoRepositorio;

	public List<Produto> listarProdutos() {
		return produtoRepositorio.findAll();
	}

	public Produto listarPorId(Integer id) throws IdNotFoundException {
		Optional<Produto> optional = produtoRepositorio.findById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException();
		}
		return optional.get();
	}

	public void insert(Produto produto) {
		produtoRepositorio.save(produto);
	}
}
