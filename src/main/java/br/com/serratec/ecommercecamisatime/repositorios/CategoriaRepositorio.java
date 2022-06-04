package br.com.serratec.ecommercecamisatime.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.ecommercecamisatime.models.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer>{
	
	public Optional<Categoria> findByNome(String nome);
}
