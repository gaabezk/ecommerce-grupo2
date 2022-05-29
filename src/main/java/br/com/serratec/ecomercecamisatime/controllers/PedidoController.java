package br.com.serratec.ecomercecamisatime.controllers;

import br.com.serratec.ecomercecamisatime.models.Pedido;
import br.com.serratec.ecomercecamisatime.models.Produto;
import br.com.serratec.ecomercecamisatime.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> getAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Lista de Pedidos", "Segue a lista de pedidos");
        return new ResponseEntity<List<Pedido>>(pedidoService.listarPedidos(), headers, HttpStatus.valueOf(202));
    }
    @PostMapping
    public ResponseEntity<Pedido> insert (@RequestBody Pedido pedido){
        pedidoService.insert(pedido);
        HttpHeaders headers = new HttpHeaders();
        headers.add("fazer pedido", "faz um pedido e retorna ele");
        return new ResponseEntity<>(pedido, headers, HttpStatus.CREATED);
    }
}
