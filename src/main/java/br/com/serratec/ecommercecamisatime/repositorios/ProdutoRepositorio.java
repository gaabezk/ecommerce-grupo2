package br.com.serratec.ecommercecamisatime.repositorios;

import br.com.serratec.ecommercecamisatime.models.Produto;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepositorio extends JpaRepository<Produto, Integer> {

	Optional<Produto> findByNome(String nome);
}
