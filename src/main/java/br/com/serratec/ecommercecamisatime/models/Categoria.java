package br.com.serratec.ecommercecamisatime.models;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Categoria {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		private String nome;
		
		@OneToMany(mappedBy = "produto")
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
