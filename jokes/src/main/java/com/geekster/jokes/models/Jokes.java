package com.geekster.jokes.models;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
public class Jokes {
    @NotBlank(message = "UserId is mandatory")
    private String userId;
    @NotBlank(message = "Username is mandatory")
    private String userName;
    @NotBlank(message = "Date of Birth is mandatory")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Date of Birth should be in yyyy-MM-dd format")
    private String dateOfBirth;
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;
    @NotBlank(message = "Phone Number is mandatory")
    @Pattern(regexp = "^\\d{2}\\d{10}$", message = "Phone Number should be 12 digits and start with a two-digit country code")
    private String PhoneNumber;
    @NotBlank(message = "Date of Birth is mandatory")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Date should be in yyyy-MM-dd format")
    private String date;
    @DateTimeFormat(pattern = "HH:mm:ss")
    private String time;

}
