package br.com.gabrielcaio.ams.domain.repository;

import br.com.gabrielcaio.ams.domain.model.ClassGroup;
import java.util.Optional;

public interface ClassGroupRepository {
  Boolean existsByName(String name);
  Optional<String> getSemesterByName(String name);
  Optional<Integer> getMaxStudents(String name);
  Optional<String> getProfessorName(String nameOfClassGroup);
  ClassGroup save(ClassGroup classGroup);
}
