package br.com.serratec.ecommercecamisatime.repositorios;

import br.com.serratec.ecommercecamisatime.models.ProdutosPedidos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosPedidosRepositorio extends JpaRepository<ProdutosPedidos, Integer> {
}
