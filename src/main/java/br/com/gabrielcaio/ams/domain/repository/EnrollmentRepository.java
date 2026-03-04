package br.com.gabrielcaio.ams.domain.repository;

import br.com.gabrielcaio.ams.domain.model.Enrollment;

public interface EnrollmentRepository {
  Boolean existsByStudentNameAndClassGroupName(String studentName, String classGroupName);
  Enrollment findByStudentName(String studentName);
  Enrollment save(Enrollment enrollment);
}
