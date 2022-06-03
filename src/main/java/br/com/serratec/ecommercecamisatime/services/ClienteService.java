package br.com.serratec.ecommercecamisatime.services;


import br.com.serratec.ecommercecamisatime.exceptions.CpfExistentException;
import br.com.serratec.ecommercecamisatime.exceptions.IdNotFoundException;
import br.com.serratec.ecommercecamisatime.models.Cliente;
import br.com.serratec.ecommercecamisatime.modelsDTO.CriarContaDTO;
import br.com.serratec.ecommercecamisatime.repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

	@Autowired
	ClienteRepositorio clienteRepositorio;

	public List<Cliente> listarClientes() {
		return clienteRepositorio.findAll();
	}

	public Cliente listarPorId(Integer id) throws IdNotFoundException {
		Optional<Cliente> optional = clienteRepositorio.findById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException();
		}
		return optional.get();
	}

	public void verificarCpf(String cpf) throws CpfExistentException {
		Optional<Cliente> optional = clienteRepositorio.findByCpf(cpf);
		if (optional.isPresent()) {
			throw new CpfExistentException();
		}
	}

	public Cliente cadastro(CriarContaDTO clienteDTO) throws CpfExistentException {
		verificarCpf(clienteDTO.getCpf());
		return clienteRepositorio.save(new Cliente(clienteDTO));
	}
}
