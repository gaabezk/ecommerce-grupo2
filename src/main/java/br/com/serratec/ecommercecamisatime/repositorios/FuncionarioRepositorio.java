package br.com.serratec.ecommercecamisatime.repositorios;

import br.com.serratec.ecommercecamisatime.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioRepositorio extends JpaRepository<Funcionario, Integer> {
    Optional<Funcionario> findByCpf(String cpf);
}
