package br.com.serratec.ecommercecamisatime.restClient;

import br.com.serratec.ecommercecamisatime.modelsDTO.ViaCepDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestViaCep {

    public ViaCepDTO getViaCep(String cep){
        String url = "https://viacep.com.br/ws/"+ cep +"/json/";
        RestTemplate restT = new RestTemplate();
        ViaCepDTO enderecoRetornado = restT.getForObject(url,ViaCepDTO.class);
        return enderecoRetornado;
    }

}
