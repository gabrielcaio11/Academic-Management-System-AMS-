package br.com.gabrielcaio.ams.presentation.dtos;

import java.time.LocalDate;

public record StudentResponse(
    Long id,
    String name,
    String registrationNumber,
    LocalDate birthDate
) {

}
