package br.com.serratec.ecommercecamisatime.controllers;

import br.com.serratec.ecommercecamisatime.exceptions.EstoqueInsuficienteException;
import br.com.serratec.ecommercecamisatime.exceptions.IdNotFoundException;
import br.com.serratec.ecommercecamisatime.models.Pedido;
import br.com.serratec.ecommercecamisatime.modelsDTO.PedidoDTO;
import br.com.serratec.ecommercecamisatime.modelsDTO.ProdutoDTO2;
import br.com.serratec.ecommercecamisatime.services.PedidoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;
@RestController
@RequestMapping("/pedido")
@Api(value = "Camisas API REST")
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

    @PostMapping("/{cpf}")
    @ApiOperation(value = "Insere um pedido no banco de dados")
    public ResponseEntity<Pedido> insert(@RequestBody ProdutoDTO2 produtosDTO2, @PathVariable String cpf) throws EstoqueInsuficienteException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Insere pedido", "insere um pedido e retorna ele");
        return new ResponseEntity<Pedido>(pedidoService.fazerPedido(produtosDTO2, cpf), headers, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> alterar(@Valid @RequestBody PedidoDTO pedidoDTO, @PathVariable Integer id)
            throws IdNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Alterar pedido", "Altera um pedido e retorna ele");
        return new ResponseEntity<>(pedidoService.alterar(pedidoDTO, id), headers, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{numero}")
    public ResponseEntity<String> deletar(@Valid @PathVariable Integer numero) throws IdNotFoundException {
        pedidoService.deletar(numero);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Deletar pedido", "Deleta um pedido");
        return new ResponseEntity<>("Pedido deletado!", headers, HttpStatus.valueOf(202));
    }
}
