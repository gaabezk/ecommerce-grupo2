package com.serratec.ecommerceapi.config;

import com.serratec.ecommerceapi.dto.ViaCepDto;
import com.serratec.ecommerceapi.models.AddressEntity;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();

//        modelMapper.createTypeMap(UserRequestDto.class, UserEntity.class)
//                .<String>addMapping(
//                        UserRequestDto::getPassword,
//                        UserEntity::setHashPassword
//                );

        modelMapper.createTypeMap(ViaCepDto.class, AddressEntity.class)
                .<String>addMapping(
                        ViaCepDto::getLogradouro,
                        AddressEntity::setRua
                )
                .<String>addMapping(
                        ViaCepDto::getLocalidade,
                        AddressEntity::setCidade
                )
                .<String>addMapping(
                        ViaCepDto::getUf,
                        AddressEntity::setEstado
                );
        return modelMapper;
    }
}
