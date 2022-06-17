package br.com.serratec.ecommercecamisatime.models;

import javax.persistence.*;

@Entity
public class Imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "mimetype")
    private String mimetype;
    @Lob
    private byte[] dados;
    @OneToOne
    private Produto produto;

    public Imagem() {
    }

    public Imagem(Integer id, String nome, String mimetype, byte[] dados, Produto produto) {
        this.id = id;
        this.nome = nome;
        this.mimetype = mimetype;
        this.dados = dados;
        this.produto = produto;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMimetype() {
        return mimetype;
    }

    public void setMimetype(String mimetype) {
        this.mimetype = mimetype;
    }

    public byte[] getDados() {
        return dados;
    }

    public void setDados(byte[] dados) {
        this.dados = dados;
    }

    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
