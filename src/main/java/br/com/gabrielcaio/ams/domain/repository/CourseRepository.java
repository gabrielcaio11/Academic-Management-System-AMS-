package br.com.gabrielcaio.ams.domain.repository;

import br.com.gabrielcaio.ams.domain.model.Course;
import java.util.Optional;

public interface CourseRepository {
  Boolean existsByName(String name);
  Optional<Course> findByName(String name);
  Course save(Course course);
  Course update(Course course);
}
