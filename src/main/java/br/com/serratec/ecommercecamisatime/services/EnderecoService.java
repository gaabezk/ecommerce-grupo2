package br.com.serratec.ecommercecamisatime.services;

import br.com.serratec.ecommercecamisatime.exceptions.CpfNonexistentException;
import br.com.serratec.ecommercecamisatime.exceptions.EnderecoNonexistentException;
import br.com.serratec.ecommercecamisatime.exceptions.IdNotFoundException;
import br.com.serratec.ecommercecamisatime.modelsDTO.ClienteDTO;
import br.com.serratec.ecommercecamisatime.modelsDTO.EnderecoDTO;
import br.com.serratec.ecommercecamisatime.restClient.RestViaCep;
import br.com.serratec.ecommercecamisatime.models.Cliente;
import br.com.serratec.ecommercecamisatime.models.Endereco;
import br.com.serratec.ecommercecamisatime.modelsDTO.ViaCepDTO;
import br.com.serratec.ecommercecamisatime.repositorios.EnderecoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

	@Autowired
	EnderecoRepositorio enderecoRepositorio;
	@Autowired
	RestViaCep restViaCep;
	@Autowired
	ClienteService clienteService;

	public List<Endereco> findAll() {
		return enderecoRepositorio.findAll();
	}

	public Endereco findByEndereco(String cep, String numero) throws EnderecoNonexistentException {
		Optional<Endereco> optional = enderecoRepositorio.findByCepAndNumero(cep, numero);
		if (optional.isEmpty()) {
			throw new EnderecoNonexistentException();
		}
		return optional.get();
	}

	public Endereco create(EnderecoDTO enderecoDTO) throws CpfNonexistentException {

		ViaCepDTO enderecoNovo = restViaCep.getViaCep(enderecoDTO.getCep());

		Endereco endereco = new Endereco(enderecoNovo, enderecoDTO);

		endereco.setCliente(clienteService.listarPorCpf(enderecoDTO.getCliente().getCpf()));

		return enderecoRepositorio.save(endereco);
	}

	public Endereco alterar(EnderecoDTO enderecoDTO, String cep, String numero) throws EnderecoNonexistentException {
		Optional<Endereco> optional = enderecoRepositorio.findByCepAndNumero(cep, numero);
		if (optional.isEmpty()) {
			throw new EnderecoNonexistentException();
		}
		Endereco oldEndereco = optional.get();

		if (enderecoDTO.getNumero() != null) {
			oldEndereco.setNumero(enderecoDTO.getNumero());
		}
		if (enderecoDTO.getComplemento() != null) {
			oldEndereco.setComplemento(enderecoDTO.getComplemento());
		}
		return enderecoRepositorio.save(oldEndereco);
	}

	public void deletar(String cep, String numero) throws EnderecoNonexistentException {
		Optional<Endereco> optional = enderecoRepositorio.findByCepAndNumero(cep, numero);
		if (optional.isEmpty()) {
			throw new EnderecoNonexistentException();
		}
		enderecoRepositorio.delete(optional.get());
	}

}
