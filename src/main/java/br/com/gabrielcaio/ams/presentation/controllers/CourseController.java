package br.com.gabrielcaio.ams.presentation.controllers;

import br.com.gabrielcaio.ams.application.usecases.RegisterCourseUseCase;
import br.com.gabrielcaio.ams.presentation.dtos.RegisterCourseRequest;
import br.com.gabrielcaio.ams.presentation.dtos.RegisterCourseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {

  private final RegisterCourseUseCase registerCourseUseCase;

  public CourseController(RegisterCourseUseCase registerCourseUseCase) {
    this.registerCourseUseCase = registerCourseUseCase;
  }

  @PostMapping
  public ResponseEntity<RegisterCourseResponse> create(RegisterCourseRequest request){
    RegisterCourseResponse courseResponse = registerCourseUseCase.execute(request);
    return ResponseEntity.ok(courseResponse);
  }
}
