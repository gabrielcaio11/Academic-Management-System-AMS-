package br.com.gabrielcaio.ams.infrastructure.persistence;

import br.com.gabrielcaio.ams.domain.model.Student;
import br.com.gabrielcaio.ams.domain.repository.StudentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaStudentRepository extends JpaRepository<Student, Long>, StudentRepository {

}
