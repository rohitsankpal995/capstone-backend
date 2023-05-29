package com.rohit.lms.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserUpadteDto {
    private Long userId;

    @NotEmpty(message = "Username cant be empty")
    @NotNull(message = "Username cant be null")
    @NotBlank(message = "Username cant be blank")
    private String userName;

//    private String password;

    @NotEmpty(message = "role cant be empty")
    @NotNull(message = "role cant be null")
    @NotBlank(message = "role is mandetory")
    private String role;
}
