package com.rohit.lms.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Setter
@Getter
public class LoginDto {
    private String userName;
    @NotNull(message = "Password should not be null")
    @NotBlank(message = "Password is mandatory")
    private String password;
}