package br.com.serratec.ecommercecamisatime.services;

import br.com.serratec.ecommercecamisatime.models.Pedido;
import br.com.serratec.ecommercecamisatime.repositorios.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    PedidoRepositorio pedidoRepositorio;

    public List<Pedido> listarPedidos(){
        return pedidoRepositorio.findAll();
    }
    public void insert(Pedido pedido) {
        pedidoRepositorio.save(pedido);
    }
}
