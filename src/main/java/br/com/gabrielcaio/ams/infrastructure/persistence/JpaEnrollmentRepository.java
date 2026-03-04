package br.com.gabrielcaio.ams.infrastructure.persistence;

import br.com.gabrielcaio.ams.domain.model.Enrollment;
import br.com.gabrielcaio.ams.domain.repository.EnrollmentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaEnrollmentRepository extends JpaRepository<Enrollment, Long>, EnrollmentRepository {

  @Query("SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END " +
          "FROM Enrollment e " +
          "WHERE e.student.name = :studentName AND e.classGroup.name = :classGroupName")
  Boolean existsByStudentNameAndClassGroupName(String studentName, String classGroupName);

  @Query("SELECT e FROM Enrollment e " +
          "WHERE e.student.name = :studentName")
  Enrollment findByStudentName(String studentName);
}