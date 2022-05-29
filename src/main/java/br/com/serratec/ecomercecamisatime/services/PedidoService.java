package br.com.serratec.ecomercecamisatime.services;

import br.com.serratec.ecomercecamisatime.controllers.PedidoController;
import br.com.serratec.ecomercecamisatime.models.Pedido;
import br.com.serratec.ecomercecamisatime.models.Produto;
import br.com.serratec.ecomercecamisatime.repositorios.PedidoRepositorio;
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
