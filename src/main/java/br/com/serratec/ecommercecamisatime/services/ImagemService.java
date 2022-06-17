package br.com.serratec.ecommercecamisatime.services;

import br.com.serratec.ecommercecamisatime.exceptions.IdNotFoundException;
import br.com.serratec.ecommercecamisatime.models.Imagem;
import br.com.serratec.ecommercecamisatime.models.Produto;
import br.com.serratec.ecommercecamisatime.repositorios.ImagemRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.URI;
import java.util.Optional;

@Service
public class ImagemService {

    @Autowired
    ImagemRepositorio imagemRepositorio;

    @Transactional
    public Imagem create(Produto produto, MultipartFile file) throws IOException {
        Imagem imagem = new Imagem();
        imagem.setNome("imagem");
        imagem.setMimetype(file.getContentType());
        imagem.setDados(file.getBytes());
        imagem.setProduto(produto);
        return imagemRepositorio.save(imagem);
    }
    public String createUrl(Integer id){
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/produto/{id}/imagem/").buildAndExpand(id).toUri();

        return uri.toString();

    }
    @Transactional
    public Imagem getImagem(Integer id) throws IdNotFoundException {
        Optional<Imagem> optional = imagemRepositorio.findByProdutoId(id);
        if (optional.isEmpty()) {
            throw new IdNotFoundException();
        }
        return optional.get();

    }
}
