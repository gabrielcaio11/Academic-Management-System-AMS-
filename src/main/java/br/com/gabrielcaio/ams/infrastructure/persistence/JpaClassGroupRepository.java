package br.com.gabrielcaio.ams.infrastructure.persistence;

import br.com.gabrielcaio.ams.domain.model.ClassGroup;
import br.com.gabrielcaio.ams.domain.repository.ClassGroupRepository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaClassGroupRepository extends JpaRepository<ClassGroup, Long>, ClassGroupRepository {

  @Query("select c.semester from ClassGroup c where c.name = :name")
  Optional<String> getSemesterByName(@Param("name") String name);

  @Query("select c.maxStudents from ClassGroup c where c.name = :name")
  Optional<Integer> getMaxStudents(@Param("name") String name);

  @Query("select c.professor.name from ClassGroup c where c.name = :name")
  Optional<String> getProfessorName(@Param("name") String name);
}