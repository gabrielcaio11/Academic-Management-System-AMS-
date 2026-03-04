package br.com.gabrielcaio.ams.infrastructure.persistence;

import br.com.gabrielcaio.ams.domain.model.Professor;
import br.com.gabrielcaio.ams.domain.repository.ProfessorRepository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProfessorRepository extends JpaRepository<Professor, Long>, ProfessorRepository {

  @Query("select c.name from ClassGroup c where c.professor.name = :professorName")
  List<String> getClassGroupsNamesByProfessorName(String professorName);
}