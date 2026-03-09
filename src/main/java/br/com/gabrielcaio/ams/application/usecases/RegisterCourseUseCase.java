package br.com.gabrielcaio.ams.application.usecases;

import br.com.gabrielcaio.ams.domain.model.Course;
import br.com.gabrielcaio.ams.domain.service.CourseService;
import br.com.gabrielcaio.ams.presentation.dtos.RegisterCourseRequest;
import br.com.gabrielcaio.ams.presentation.dtos.RegisterCourseResponse;
import org.springframework.stereotype.Component;

@Component
public class RegisterCourseUseCase {

  private final CourseService courseService;

  public RegisterCourseUseCase(
      CourseService courseService
  ) {
    this.courseService = courseService;
  }

  public RegisterCourseResponse execute(RegisterCourseRequest request) {
    Course entity = new Course(request.name(), request.description());
    Course created = courseService.create(entity);
    return new RegisterCourseResponse(created.getId(), created.getName(), created.getDescription());
  }
}
