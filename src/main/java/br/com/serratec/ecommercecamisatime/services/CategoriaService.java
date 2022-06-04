package br.com.serratec.ecommercecamisatime.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.ecommercecamisatime.exceptions.CategoriaExistenteException;
import br.com.serratec.ecommercecamisatime.exceptions.IdNotFoundException;
import br.com.serratec.ecommercecamisatime.models.Categoria;
import br.com.serratec.ecommercecamisatime.repositorios.CategoriaRepositorio;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepositorio categoriaRepositorio;
	
	public List<Categoria> listarCategoria(){
		return categoriaRepositorio.findAll();
	}
	
	public Categoria listarPorId(Integer id) throws IdNotFoundException {
		Optional<Categoria> optional = categoriaRepositorio.findById(id);
		if(optional.isEmpty()) {
			throw new IdNotFoundException();
		}
		return optional.get();
	}
	
	public void verificaCategoria(String nomeCategoria) throws CategoriaExistenteException {
		Optional<Categoria> optional = categoriaRepositorio.findByNome(nomeCategoria);
		if(optional.isPresent()) {
			throw new CategoriaExistenteException();
		}
	}
	
	public Categoria criaCategoria(Categoria categoria) throws CategoriaExistenteException {
		verificaCategoria(categoria.getNome());
		return categoriaRepositorio.save(categoria);
		
	}
	
}
