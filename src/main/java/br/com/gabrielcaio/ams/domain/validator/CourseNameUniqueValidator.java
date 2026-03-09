package br.com.gabrielcaio.ams.domain.validator;

import br.com.gabrielcaio.ams.domain.model.Course;
import br.com.gabrielcaio.ams.domain.repository.CourseRepository;
import org.springframework.stereotype.Component;

@Component
public class CourseNameUniqueValidator {
  private final CourseRepository courseRepository;

  public CourseNameUniqueValidator(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }

  public void execute(Course course) {
    if (courseRepository.existsByName(course.getName())) {
      throw new IllegalArgumentException("Course with name " + course.getName() + " already exists");
    }
  }
}