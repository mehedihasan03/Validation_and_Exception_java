package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {

    @NotNull(message = "Name shouldn't be null")
    private String name;

    @Email(message = "Email should be valid")
    private String email;

    @Pattern(regexp = "^\\d{11}$", message = "mobile number should be valid")
    private String mobile;
    private String gender;

    @Min(20)
    @Max(50)
    private int age;

    @NotBlank
    private String nationality;

}
