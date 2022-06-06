package br.com.serratec.ecommercecamisatime.repositorios;

import br.com.serratec.ecommercecamisatime.models.Imagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImagemRepositorio extends JpaRepository<Imagem, Integer> {

    Optional<Imagem> findByProdutoId(Integer id);
}
