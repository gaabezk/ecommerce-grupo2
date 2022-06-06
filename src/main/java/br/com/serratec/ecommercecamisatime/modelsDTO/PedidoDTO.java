package br.com.serratec.ecommercecamisatime.modelsDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.serratec.ecommercecamisatime.models.Cliente;

public class PedidoDTO {

	private Integer numeroPedido;
	private Cliente cliente;
	private Integer quantidadeProduto;
	public Integer getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	private Double ValorTotal;
	private boolean finalizado;
	
	public PedidoDTO() {
	}

	public Integer getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(Integer numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getValorTotal() {
		return ValorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		ValorTotal = valorTotal;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
