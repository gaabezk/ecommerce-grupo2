package br.com.serratec.ecommercecamisatime.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.ecommercecamisatime.exceptions.IdNotFoundException;
import br.com.serratec.ecommercecamisatime.models.Cliente;
import br.com.serratec.ecommercecamisatime.repositorios.ClienteRepositorio;

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

	public void insert(Cliente cliente) {
		clienteRepositorio.save(cliente);
	}

}
