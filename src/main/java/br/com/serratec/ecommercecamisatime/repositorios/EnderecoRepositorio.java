package br.com.serratec.ecommercecamisatime.repositorios;

import br.com.serratec.ecommercecamisatime.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepositorio extends JpaRepository<Endereco, Integer> {
}
