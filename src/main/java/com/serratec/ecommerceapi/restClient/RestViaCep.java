package com.serratec.ecommerceapi.restClient;

import com.serratec.ecommerceapi.dto.ViaCepDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestViaCep {
    public ViaCepDto getViaCep(String cep){
        return new RestTemplate().getForObject("https://viacep.com.br/ws/"+ cep +"/json/",ViaCepDto.class);
    }
}
