package br.com.serratec.ecommercecamisatime.modelsDTO;

public class CategoriaDTO {

    private String nome,descricao;

    public String getNome() {
        return nome;
    }

    public CategoriaDTO() {
    }

    public CategoriaDTO(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
