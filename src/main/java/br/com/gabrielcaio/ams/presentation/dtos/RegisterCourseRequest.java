package br.com.gabrielcaio.ams.presentation.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterCourseRequest(
    @NotBlank
    @Size(min = 5,max = 10, message = "size must be between 5 and 10 characters")
    String name,

    @NotBlank
    @Size(min = 10, max = 100, message = "size must be between 10 and 100 characters")
    String description
) {
}