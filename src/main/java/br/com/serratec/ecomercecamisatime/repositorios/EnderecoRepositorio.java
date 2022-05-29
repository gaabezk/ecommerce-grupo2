package br.com.serratec.ecomercecamisatime.repositorios;

import br.com.serratec.ecomercecamisatime.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepositorio extends JpaRepository<Endereco, Integer> {
}
