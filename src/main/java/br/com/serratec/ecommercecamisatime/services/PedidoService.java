package br.com.serratec.ecommercecamisatime.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.serratec.ecommercecamisatime.exceptions.EstoqueInsuficienteException;
import br.com.serratec.ecommercecamisatime.models.Cliente;
import br.com.serratec.ecommercecamisatime.models.PedidoProdutos;
import br.com.serratec.ecommercecamisatime.models.Produto;
import br.com.serratec.ecommercecamisatime.modelsDTO.ProdutoDTO;
import br.com.serratec.ecommercecamisatime.modelsDTO.ProdutoDTO2;
import br.com.serratec.ecommercecamisatime.repositorios.ClienteRepositorio;
import br.com.serratec.ecommercecamisatime.repositorios.PedidoProdutosRepositorio;
import br.com.serratec.ecommercecamisatime.repositorios.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.serratec.ecommercecamisatime.exceptions.IdNotFoundException;
import br.com.serratec.ecommercecamisatime.models.Pedido;
import br.com.serratec.ecommercecamisatime.modelsDTO.PedidoDTO;
import br.com.serratec.ecommercecamisatime.repositorios.PedidoRepositorio;

import javax.transaction.Transactional;

@Service
public class PedidoService {

    @Autowired
    PedidoRepositorio pedidoRepositorio;
    @Autowired
    PedidoProdutosRepositorio pedidoProdutosRepositorio;
    @Autowired
    ClienteRepositorio clienteRepositorio;
    @Autowired
    ProdutoRepositorio produtoRepositorio;

    public List<Pedido> listarPedidos() {
        return pedidoRepositorio.findAll();
    }

//	public void insert(Pedido pedido) {

//		System.out.println(pedido);
//		pedido.setDataPedido(LocalDateTime.now());
//
//		Pedido pedido1 = pedidoRepositorio.save(pedido);
//
//		for (ProdutosPedidos pedidos : pedido.getProdutosPedidos()) {
//			pedidos.setPedido(pedido1);
//			System.out.println(pedidos.getProduto().getId());
//		}
//
//		produtosPedidosRepositorio.saveAll(pedido.getProdutosPedidos());

    //	}
    @Transactional
    public Pedido fazerPedido(ProdutoDTO2 produtos, String cpf) throws EstoqueInsuficienteException {
        Optional<Cliente> cliente = clienteRepositorio.findByCpf(cpf);
        Optional<Produto> produto = produtoRepositorio.findById(produtos.getId());

        Pedido pedido = new Pedido(cliente.get());

        Produto produto1 = produto.get();

        if (produto1.getQuantidadeEstoque() < produtos.getQuantidade()) {
            throw new EstoqueInsuficienteException();
        }

        PedidoProdutos pedidoProdutos = new PedidoProdutos();

        pedidoProdutos.setProduto(produto1);
        pedidoProdutos.setPedido(pedido);
        pedidoProdutos.setQuantidade(produtos.getQuantidade());
        pedidoProdutos.setPreco(produtos.getPreco());


        List<PedidoProdutos> listaProdutos = new ArrayList<>();
        listaProdutos.add(pedidoProdutos);

        pedido.setProdutos(listaProdutos);

        pedido.setValorTotal(produtos.getQuantidade() * produtos.getPreco());

        produto1.setQuantidadeEstoque(produto1.getQuantidadeEstoque() - produtos.getQuantidade());

        produtoRepositorio.save(produto1);
        pedidoProdutosRepositorio.save(pedidoProdutos);

        return pedidoRepositorio.save(pedido);
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

    public void deletar(Integer numero) throws IdNotFoundException {
        Optional<Pedido> optional = pedidoRepositorio.findByNumPedido(numero);
        if (optional.isEmpty()) {
            throw new IdNotFoundException();
        }
        pedidoRepositorio.delete(optional.get());
    }
}
