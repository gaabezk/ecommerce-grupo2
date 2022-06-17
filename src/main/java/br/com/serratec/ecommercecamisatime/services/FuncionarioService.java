package br.com.serratec.ecommercecamisatime.services;

import br.com.serratec.ecommercecamisatime.exceptions.CpfExistentException;
import br.com.serratec.ecommercecamisatime.exceptions.CpfNonexistentException;
import br.com.serratec.ecommercecamisatime.exceptions.EmailExistentException;
import br.com.serratec.ecommercecamisatime.exceptions.IdNotFoundException;
import br.com.serratec.ecommercecamisatime.models.Funcionario;
import br.com.serratec.ecommercecamisatime.modelsDTO.FuncionarioDTO;
import br.com.serratec.ecommercecamisatime.repositorios.FuncionarioRepositorio;
import br.com.serratec.ecommercecamisatime.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepositorio funcionarioRepositorio;
    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    public List<Funcionario> listar() {
        return funcionarioRepositorio.findAll();
    }

    public Funcionario listarPorId(Integer id) throws IdNotFoundException {
        Optional<Funcionario> optional = funcionarioRepositorio.findById(id);
        if (optional.isEmpty()) {
            throw new IdNotFoundException();
        }
        return optional.get();
    }

    public Funcionario listarPorCpf(String cpf) throws CpfNonexistentException {
        Optional<Funcionario> optional = funcionarioRepositorio.findByCpf(cpf);
        if (optional.isEmpty()) {
            throw new CpfNonexistentException();
        }
        return optional.get();
    }

    public void verificarCpf(String cpf) throws CpfExistentException {
        Optional<Funcionario> optional = funcionarioRepositorio.findByCpf(cpf);
        if (optional.isPresent()) {
            throw new CpfExistentException();
        }
    }

    public Funcionario cadastro(FuncionarioDTO funcionarioDTO,String cpf) throws CpfExistentException, EmailExistentException, CpfNonexistentException {
        Optional<Funcionario> func = funcionarioRepositorio.findByCpf(cpf);
        if (func.isEmpty()){
            throw new CpfNonexistentException();
        }

        verificarCpf(funcionarioDTO.getCpf());

        Funcionario funcionario = new Funcionario(funcionarioDTO);

        Optional<?> optional = usuarioRepositorio.findByEmail(funcionario.getUsuario().getEmail());
        if (optional.isPresent()) {
            throw new EmailExistentException();
        }

        return funcionarioRepositorio.save(funcionario);
    }

    public Funcionario alterar(FuncionarioDTO funcionarioDTO, String cpf) throws CpfNonexistentException {
        Optional<Funcionario> optional = funcionarioRepositorio.findByCpf(cpf);
        if (optional.isEmpty()) {
            throw new CpfNonexistentException();
        }
        Funcionario oldFuncionario = optional.get();

        if (funcionarioDTO.getNome() != null) {
            oldFuncionario.setNome(funcionarioDTO.getNome());
        }
        if (funcionarioDTO.getTelefone() != null) {
            oldFuncionario.setTelefone(funcionarioDTO.getTelefone());
        }
        return funcionarioRepositorio.save(oldFuncionario);
    }

    public void deletar(String cpf) throws CpfNonexistentException {
        Optional<Funcionario> optional = funcionarioRepositorio.findByCpf(cpf);
        if (optional.isEmpty()) {
            throw new CpfNonexistentException();
        }
        funcionarioRepositorio.delete(optional.get());
    }
}
