package br.com.serratec.ecommercecamisatime.models;

import java.util.List;

import javax.persistence.*;

@Entity
public class Categoria {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		private String nome;
		
		@OneToMany(mappedBy = "categoria")
		private List<Produto> produtos;
		
		public Categoria() {
			super();
		}


		public Categoria(Integer id, String nome) {
			super();
			this.id = id;
			this.nome = nome;
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
		
		
		
}
