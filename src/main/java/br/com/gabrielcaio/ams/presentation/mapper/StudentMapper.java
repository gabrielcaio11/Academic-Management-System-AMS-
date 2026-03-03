package br.com.gabrielcaio.ams.presentation.mapper;

import br.com.gabrielcaio.ams.domain.model.Student;
import br.com.gabrielcaio.ams.presentation.dtos.StudentRequest;
import br.com.gabrielcaio.ams.presentation.dtos.StudentResponse;

public class StudentMapper {

  public static Student toEntity(StudentRequest dto) {
    return new Student(
        dto.name(),
        dto.email(),
        dto.registrationNumber(),
        dto.birthDate()
    );
  }

  public static StudentResponse toResponse(Student student) {
    return new StudentResponse(
        student.getId(),
        student.getFullName(),
        student.getRegistrationNumber(),
        student.getBirthDate()
    );
  }
}
