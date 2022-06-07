package br.com.serratec.ecommercecamisatime.modelsDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.serratec.ecommercecamisatime.models.Cliente;

public class PedidoDTO {

	public Integer idProduto;

	public Double valorTotal;


	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
}
