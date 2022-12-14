package com.toyproject.jpaBoard.user.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class LoginUserForm {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Length(min = 8, max = 50)
    private String password;
}
