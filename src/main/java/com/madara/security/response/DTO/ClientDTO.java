package com.madara.security.response.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    @NotEmpty(message = "Name should not be empty")
    @NotBlank(message = "Name should not be blank")
    private String name;
    @NotEmpty(message = "Email should not be empty")
    @NotBlank(message = "Email should not be blank")
    @Email(message = "Email format is required use @")
    private String email;
    @NotBlank(message = "phone number should be filled")
    @Pattern(
            regexp = "^[6-9]\\d{9}$",
            message = "Invalid phone number"
    )
    private String phoneNumber;
    @NotEmpty(message = "Address should not be empty")
    @NotBlank(message = "Address should not be blank")
    private String address;
}
