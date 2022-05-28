package br.com.serratec.ecomercecamisatime.repositories;

import br.com.serratec.ecomercecamisatime.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepositorio extends JpaRepository<Produto,Integer> {
}
