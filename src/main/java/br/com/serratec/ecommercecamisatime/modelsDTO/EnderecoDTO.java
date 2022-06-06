package br.com.serratec.ecommercecamisatime.modelsDTO;

import br.com.serratec.ecommercecamisatime.models.Cliente;

public class EnderecoDTO {
    private String cep,numero, complemento;

    private Cliente cliente;

    public EnderecoDTO() {
    }

    public EnderecoDTO(String cep, String numero, String complemento, Cliente cliente) {
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
        this.cliente = cliente;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
