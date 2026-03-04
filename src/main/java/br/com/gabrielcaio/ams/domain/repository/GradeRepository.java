package br.com.gabrielcaio.ams.domain.repository;

import br.com.gabrielcaio.ams.domain.model.Grade;
import java.util.Optional;

public interface GradeRepository {
  Boolean existsByEnrollmentStudentNameAndEnrollmentClassGroupName(String studentName, String classGroupName);
  Optional<Double> getValueByEnrollmentId(Long enrollmentId);
  Grade save(Grade grade);
}
