package br.com.serratec.ecommercecamisatime.repositorios;

import br.com.serratec.ecommercecamisatime.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PedidoRepositorio extends JpaRepository<Pedido, Integer> {
    Optional<Pedido> findByNumPedido(Integer numPedido);
}
