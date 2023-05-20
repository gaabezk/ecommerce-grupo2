package com.serratec.ecommerceapi.enums;

import jakarta.validation.constraints.NotBlank;

public enum Role {
    @NotBlank
    CLIENT,
    @NotBlank
    EMPLOYEE

}
