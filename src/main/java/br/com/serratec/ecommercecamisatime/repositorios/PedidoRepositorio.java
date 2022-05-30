package br.com.serratec.ecommercecamisatime.repositorios;

import br.com.serratec.ecommercecamisatime.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepositorio extends JpaRepository<Pedido, Integer> {
}
