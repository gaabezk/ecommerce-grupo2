package br.com.serratec.ecommercecamisatime.services;

import java.util.List;
import java.util.Optional;

import br.com.serratec.ecommercecamisatime.exceptions.CategoriaNonexistentException;
import br.com.serratec.ecommercecamisatime.exceptions.CpfNonexistentException;
import br.com.serratec.ecommercecamisatime.models.Funcionario;
import br.com.serratec.ecommercecamisatime.modelsDTO.CategoriaDTO;
import br.com.serratec.ecommercecamisatime.repositorios.FuncionarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.ecommercecamisatime.exceptions.CategoriaExistentException;
import br.com.serratec.ecommercecamisatime.exceptions.IdNotFoundException;
import br.com.serratec.ecommercecamisatime.models.Categoria;
import br.com.serratec.ecommercecamisatime.repositorios.CategoriaRepositorio;

@Service
public class CategoriaService {
	@Autowired
	FuncionarioRepositorio funcionarioRepositorio;
	@Autowired
	CategoriaRepositorio repositorio;
	
	public List<Categoria> listar(){
		return repositorio.findAll();
	}
	
	public Categoria listarPorNome(String nome) throws CategoriaNonexistentException {
		Optional<Categoria> optional = repositorio.findByNome(nome);
		if(optional.isEmpty()) {
			throw new CategoriaNonexistentException();
		}
		return optional.get();
	}
	
	public void verificar(String nomeCategoria) throws CategoriaExistentException {
		Optional<Categoria> optional = repositorio.findByNome(nomeCategoria);
		if(optional.isPresent()) {
			throw new CategoriaExistentException();
		}
	}
	
	public Categoria criar(Categoria categoria,String cpf) throws CategoriaExistentException, CpfNonexistentException {
		Optional<Funcionario> funcionario = funcionarioRepositorio.findByCpf(cpf);
		if (funcionario.isEmpty()){
			throw new CpfNonexistentException();
		}
		verificar(categoria.getNome());
		return repositorio.save(categoria);
	}

	public Categoria alterar(CategoriaDTO categoria, String nome) throws CategoriaNonexistentException {
		Optional<Categoria> optional = repositorio.findByNome(nome);
		if(optional.isEmpty()){
			throw new CategoriaNonexistentException();
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

	public void deletar(String nome) throws CategoriaNonexistentException {
		Optional<Categoria> optional = repositorio.findByNome(nome);
		if(optional.isEmpty()){
			throw new CategoriaNonexistentException();
		}
		repositorio.delete(optional.get());
	}

}
