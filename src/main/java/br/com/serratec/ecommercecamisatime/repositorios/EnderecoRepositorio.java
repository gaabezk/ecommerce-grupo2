package br.com.serratec.ecommercecamisatime.repositorios;

import br.com.serratec.ecommercecamisatime.models.Endereco;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepositorio extends JpaRepository<Endereco, Integer> {

	Optional<Endereco> findByCep(String cep);
	
	Optional<Endereco> findByCepAndNumero(String cep, String numero);
	
}
