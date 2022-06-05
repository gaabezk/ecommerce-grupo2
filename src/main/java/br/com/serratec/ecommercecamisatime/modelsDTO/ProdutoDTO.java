package br.com.serratec.ecommercecamisatime.modelsDTO;

import br.com.serratec.ecommercecamisatime.models.Categoria;
import br.com.serratec.ecommercecamisatime.models.Funcionario;
import br.com.serratec.ecommercecamisatime.models.Produto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.Instant;

public class ProdutoDTO {

    private String nome;
    private String descricao;
    private String tamanho;
    private String genero;
    private Integer quantidadeEstoque;
    private Instant dataCadastro;
    private Double valor;

    @JsonIgnore
    private Funcionario funcionario;

    @JsonIgnore
    private Categoria categoria;

    public ProdutoDTO() {
    }

    public ProdutoDTO(String nome, String descricao, String tamanho, String genero, Integer quantidadeEstoque, Instant dataCadastro, Double valor, Funcionario funcionario, Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.tamanho = tamanho;
        this.genero = genero;
        this.quantidadeEstoque = quantidadeEstoque;
        this.dataCadastro = dataCadastro;
        this.valor = valor;
        this.funcionario = funcionario;
        this.categoria = categoria;
    }
    public ProdutoDTO(Produto produto) {
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.tamanho = produto.getTamanho();
        this.genero = produto.getGenero();
        this.quantidadeEstoque = produto.getQuantidadeEstoque();
        this.dataCadastro = produto.getDataCadastro();
        this.valor = produto.getValor();
        this.funcionario = produto.getFuncionario();
        this.categoria = produto.getCategoria();
    }

    public String getNome() {
        return nome;
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

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Instant getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Instant dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
