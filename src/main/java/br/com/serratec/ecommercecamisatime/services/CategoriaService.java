package br.com.serratec.ecommercecamisatime.services;

import java.util.List;
import java.util.Optional;

import br.com.serratec.ecommercecamisatime.exceptions.CategoriaInexistenteException;
import br.com.serratec.ecommercecamisatime.modelsDTO.CategoriaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.ecommercecamisatime.exceptions.CategoriaExistenteException;
import br.com.serratec.ecommercecamisatime.exceptions.IdNotFoundException;
import br.com.serratec.ecommercecamisatime.models.Categoria;
import br.com.serratec.ecommercecamisatime.repositorios.CategoriaRepositorio;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepositorio repositorio;
	
	public List<Categoria> listar(){
		return repositorio.findAll();
	}
	
	public Categoria listarPorId(Integer id) throws IdNotFoundException {
		Optional<Categoria> optional = repositorio.findById(id);
		if(optional.isEmpty()) {
			throw new IdNotFoundException();
		}
		return optional.get();
	}
	
	public void verificar(String nomeCategoria) throws CategoriaExistenteException {
		Optional<Categoria> optional = repositorio.findByNome(nomeCategoria);
		if(optional.isPresent()) {
			throw new CategoriaExistenteException();
		}
	}
	
	public Categoria criar(Categoria categoria) throws CategoriaExistenteException {
		verificar(categoria.getNome());
		return repositorio.save(categoria);
	}

	public Categoria alterar(CategoriaDTO categoria, String nome) throws CategoriaInexistenteException {
		Optional<Categoria> optional = repositorio.findByNome(nome);
		if(optional.isEmpty()){
			throw new CategoriaInexistenteException();
		}
		Categoria oldCategoria = optional.get();

		if (categoria.getNome() != null) {
			oldCategoria.setNome(categoria.getNome());
		}
		if (categoria.getDescricao() != null) {
			oldCategoria.setDescricao(categoria.getDescricao());
		}
		return repositorio.save(oldCategoria);
	}

	public void delete(String nome) throws CategoriaInexistenteException {
		Optional<Categoria> optional = repositorio.findByNome(nome);
		if(optional.isEmpty()){
			throw new CategoriaInexistenteException();
		}
		repositorio.delete(optional.get());
	}

}
