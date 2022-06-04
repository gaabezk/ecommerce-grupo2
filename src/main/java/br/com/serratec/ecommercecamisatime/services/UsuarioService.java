package br.com.serratec.ecommercecamisatime.services;

import br.com.serratec.ecommercecamisatime.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepositorio repositorio;

}
