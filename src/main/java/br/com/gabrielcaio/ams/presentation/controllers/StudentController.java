package br.com.gabrielcaio.ams.presentation.controllers;

import br.com.gabrielcaio.ams.domain.model.Student;
import br.com.gabrielcaio.ams.domain.service.StudentService;
import br.com.gabrielcaio.ams.presentation.dtos.StudentRequest;
import br.com.gabrielcaio.ams.presentation.dtos.StudentResponse;
import br.com.gabrielcaio.ams.presentation.mapper.StudentMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

  private final StudentService service;

  public StudentController(StudentService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<StudentResponse> create(
      @Valid @RequestBody StudentRequest request
  ) {
    Student student = StudentMapper.toEntity(request);
    Student registeredStudent = service.create(student);
    StudentResponse response = StudentMapper.toResponse(registeredStudent);
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(response);
  }
}
