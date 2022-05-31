package br.com.serratec.ecommercecamisatime.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.serratec.ecommercecamisatime.models.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {
}
