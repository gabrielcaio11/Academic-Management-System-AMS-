package br.com.gabrielcaio.ams.presentation.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import java.time.LocalDate;

public record StudentRequest(
    @NotBlank String name,
    @NotBlank String email,
    @NotBlank String registrationNumber,
    @Past LocalDate birthDate
) {

}
