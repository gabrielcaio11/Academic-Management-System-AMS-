package br.com.gabrielcaio.ams.infrastructure.persistence;

import br.com.gabrielcaio.ams.domain.model.Grade;
import br.com.gabrielcaio.ams.domain.repository.GradeRepository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaGradeRepository extends JpaRepository<Grade, Long>, GradeRepository {

  @Query("select case when count(g) > 0 then true else false end " +
      "from Grade g " +
      "where g.enrollment.student.name = :studentName and " +
      "g.enrollment.classGroup.name = :classGroupName")
  Boolean existsByEnrollmentStudentNameAndEnrollmentClassGroupName(String studentName, String classGroupName);

  @Query("select g.value from Grade g where g.enrollment.id = :enrollmentId")
  Optional<Double> getValueByEnrollmentId(Long enrollmentId);
}
