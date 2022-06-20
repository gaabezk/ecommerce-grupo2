package br.com.serratec.ecommercecamisatime.models;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Categoria {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		@NotNull
		private String nome;
		@NotNull
		private String descricao;

		@OneToMany(mappedBy = "categoria",cascade = CascadeType.ALL)
		private List<Produto> produtos;
		
		public Categoria() {
			super();
		}

		public Categoria(Integer id, String nome, String descricao) {
			super();
			this.id = id;
			this.nome = nome;
			this.descricao = descricao;
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
}
