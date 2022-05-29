package br.com.serratec.ecomercecamisatime.repositorios;

import br.com.serratec.ecomercecamisatime.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepositorio extends JpaRepository<Pedido, Integer> {
}
