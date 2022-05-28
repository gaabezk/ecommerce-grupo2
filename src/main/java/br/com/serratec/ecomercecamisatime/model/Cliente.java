package br.com.serratec.ecomercecamisatime.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cliente{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private List<Endereco> endereco;
    @Embedded
    private Usuario usuario;


}
