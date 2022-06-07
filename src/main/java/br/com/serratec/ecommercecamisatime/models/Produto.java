package br.com.serratec.ecommercecamisatime.models;

import br.com.serratec.ecommercecamisatime.modelsDTO.ProdutoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Size(max = 60)
    @Column(name = "nome")
    private String nome;
    @NotNull
    @Size(max = 80)
    @Column(name = "descricao")
    private String descricao;
    @NotNull
    @Size(max = 80)
    @Column(name = "tamanho")
    private String tamanho;
    @NotNull
    @Size(max = 80)
    @Column(name = "genero")
    private String genero;
    @NotNull
    @Column(name = "quantidade")
    private Integer quantidadeEstoque;
    @NotNull
    @Column(name = "dataCadastro")
    private Instant dataCadastro;
    @NotNull
    @Column(name = "valor")
    private Double valor;

    @JsonIgnore
    @Column(name = "url")
    private String url;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Imagem imagem;
    
    
    public Produto() {
    }

    public Produto(Integer id, String nome, String descricao, String tamanho, String genero, Integer quantidadeEstoque, Instant dataCadastro, Double valor, Funcionario funcionario,  Categoria categoria) {
        this.id = id;
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
    public Produto(ProdutoDTO produto) {
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.tamanho = produto.getTamanho();
        this.genero = produto.getGenero();
        this.quantidadeEstoque = produto.getQuantidadeEstoque();
        this.dataCadastro = produto.getDataCadastro();
        this.valor = produto.getValor();
        this.funcionario = produto.getFuncionario();
        this.categoria = produto.getCategoria();
        this.url = produto.getUrl();
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

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
