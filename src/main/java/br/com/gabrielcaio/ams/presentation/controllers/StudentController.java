package br.com.gabrielcaio.ams.presentation.controllers;

import br.com.gabrielcaio.ams.domain.service.StudentService;
import br.com.gabrielcaio.ams.presentation.dtos.StudentRequest;
import br.com.gabrielcaio.ams.presentation.dtos.StudentResponse;
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
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(service.create(request));
  }
}
