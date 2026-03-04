package br.com.gabrielcaio.ams.infrastructure.persistence;

import br.com.gabrielcaio.ams.domain.model.Course;
import br.com.gabrielcaio.ams.domain.repository.CourseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCourseRepository extends JpaRepository<Course, Long>, CourseRepository {
}