package br.com.serratec.ecommercecamisatime.controllers;

import br.com.serratec.ecommercecamisatime.models.Pedido;
import br.com.serratec.ecommercecamisatime.services.PedidoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@Api(value="Camisas API REST")
@CrossOrigin(origins = "/*")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @GetMapping
    @ApiOperation(value = "Retorna uma lista de pedidos")
    public ResponseEntity<List<Pedido>> getAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Listar Pedidos", "Segue a lista de pedidos");
        return new ResponseEntity<List<Pedido>>(pedidoService.listarPedidos(), headers, HttpStatus.valueOf(202));
    }
    @PostMapping
    @ApiOperation(value = "Insere um pedido no banco de dados")
    public ResponseEntity<Pedido> insert (@RequestBody Pedido pedido){
        pedidoService.insert(pedido);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Insere pedido", "insere um pedido e retorna ele");
        return new ResponseEntity<>(pedido, headers, HttpStatus.CREATED);
    }
}
