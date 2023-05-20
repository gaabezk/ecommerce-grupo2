package com.serratec.ecommerceapi.models;

import com.serratec.ecommerceapi.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String hashPassword;
    private String cpf;
    private String phone;
    private LocalDate birthDate;
    private Role role;
    private Boolean active;
    @OneToOne
    @JoinColumn(name = "address_id")
    private AddressEntity address;
    // private List<Order> orders;


}
