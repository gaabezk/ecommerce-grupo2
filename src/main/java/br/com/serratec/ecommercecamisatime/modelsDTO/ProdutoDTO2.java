package br.com.serratec.ecommercecamisatime.modelsDTO;

public class ProdutoDTO2 {

    private Integer id;
    private Integer quantidade;

    public ProdutoDTO2() {
    }

    public ProdutoDTO2(Integer id, Integer quantidade) {
        this.id = id;
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

}
