package br.com.serratec.ecommercecamisatime.repositorios;


import br.com.serratec.ecommercecamisatime.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {

    public Optional<Cliente> findByCpf(String cpf);

}
