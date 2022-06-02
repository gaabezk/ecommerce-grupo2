package br.com.serratec.ecommercecamisatime.repositorios;


import br.com.serratec.ecommercecamisatime.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {
}
