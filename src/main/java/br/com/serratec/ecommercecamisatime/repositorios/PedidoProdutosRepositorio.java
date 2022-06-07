package br.com.serratec.ecommercecamisatime.repositorios;

import br.com.serratec.ecommercecamisatime.models.PedidoProdutos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoProdutosRepositorio extends JpaRepository<PedidoProdutos, Integer> {
}
