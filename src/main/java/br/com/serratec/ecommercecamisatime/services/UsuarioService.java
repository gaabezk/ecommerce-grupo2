package br.com.serratec.ecommercecamisatime.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.ecommercecamisatime.exceptions.CpfExistentException;
import br.com.serratec.ecommercecamisatime.exceptions.CpfNonexistentException;
import br.com.serratec.ecommercecamisatime.exceptions.IdNotFoundException;
import br.com.serratec.ecommercecamisatime.models.Cliente;
import br.com.serratec.ecommercecamisatime.models.Usuario;
import br.com.serratec.ecommercecamisatime.repositorios.ClienteRepositorio;
import br.com.serratec.ecommercecamisatime.repositorios.UsuarioRepositorio;

@Service
public class UsuarioService {

	@Autowired
	ClienteRepositorio clienteRepositorio;
	@Autowired
	UsuarioRepositorio usuarioRepositorio;

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

	/*public Usuario cadastro(Usuario usuario, Cliente cliente) throws CpfExistentException {
		//verificarCpf(clienteDTO.getCpf());
		return usuarioRepositorio.save(new Usuario(usuario));
	}
	
	public Cliente alterar(ClienteDTO clienteDTO, String cpf) throws CpfNonexistentException {
		Optional<Cliente> optional = clienteRepositorio.findByCpf(cpf);
		if(optional.isEmpty()){
			throw new CpfNonexistentException();
		}
		Cliente oldCliente = optional.get();

		if (clienteDTO.getEnderecoDto() != null) {
			oldCliente.setEnderecoDto(clienteDTO.getEnderecoDto());
		}
		if (clienteDTO.getTelefone() != null) {
			oldCliente.setTelefone(clienteDTO.getTelefone());
		}
		return clienteRepositorio.save(oldCliente);
	}*/
	
	public void deletar(String cpf) throws CpfNonexistentException {
		Optional<Cliente> optional = clienteRepositorio.findByCpf(cpf);
		if(optional.isEmpty()){
			throw new CpfNonexistentException();
		}
		clienteRepositorio.delete(optional.get());
	}
}
