package br.com.gabrielcaio.ams.domain.service;

import br.com.gabrielcaio.ams.domain.model.Course;
import br.com.gabrielcaio.ams.domain.model.Student;
import br.com.gabrielcaio.ams.domain.repository.CourseRepository;
import br.com.gabrielcaio.ams.domain.validator.CourseNameUniqueValidator;
import org.springframework.stereotype.Component;

@Component
public class CourseService {

  private final CourseRepository courseRepository;
  private final CourseNameUniqueValidator courseNameUniqueValidator;

  public CourseService(CourseRepository courseRepository, CourseNameUniqueValidator courseNameUniqueValidator) {
    this.courseRepository = courseRepository;
    this.courseNameUniqueValidator = courseNameUniqueValidator;
  }

  public Course create(Course course){

    return courseRepository.save(course);
  }

  private void validadeCreateCourse(Course course) {
    courseNameUniqueValidator.execute(course);
  }
}
