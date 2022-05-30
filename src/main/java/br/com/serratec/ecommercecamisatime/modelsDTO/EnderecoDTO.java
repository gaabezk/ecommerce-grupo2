package br.com.serratec.ecommercecamisatime.modelsDTO;

public class EnderecoDTO {
    private String cep,numero,complento;


    public EnderecoDTO() {
    }

    public EnderecoDTO(String cep, String numero, String complento) {
        this.cep = cep;
        this.numero = numero;
        this.complento = complento;
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

    public String getComplento() {
        return complento;
    }

    public void setComplento(String complento) {
        this.complento = complento;
    }
}
