package br.com.serratec.ecommercecamisatime.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.serratec.ecommercecamisatime.exceptions.IdNotFoundException;
import br.com.serratec.ecommercecamisatime.models.Pedido;
import br.com.serratec.ecommercecamisatime.modelsDTO.PedidoDTO;
import br.com.serratec.ecommercecamisatime.repositorios.PedidoRepositorio;

@Service
public class PedidoService {

	@Autowired
	PedidoRepositorio pedidoRepositorio;

	public List<Pedido> listarPedidos() {
		return pedidoRepositorio.findAll();
	}

	public void insert(Pedido pedido) {
		pedidoRepositorio.save(pedido);
	}

	public Pedido alterar(PedidoDTO pedidoDTO, Integer id) throws IdNotFoundException {
		Optional<Pedido> optional = pedidoRepositorio.findById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException();
		}
		Pedido oldPedido = optional.get();

		if (pedidoDTO.getValorTotal() != null) {
			oldPedido.setValorTotal(pedidoDTO.getValorTotal());
		}

		return pedidoRepositorio.save(oldPedido);
	}

	public void deletar(Integer id) throws IdNotFoundException {
		Optional<Pedido> optional = pedidoRepositorio.findById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException();
		}
		pedidoRepositorio.delete(optional.get());
	}
}
