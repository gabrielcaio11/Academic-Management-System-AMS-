package br.com.gabrielcaio.ams.domain.repository;

import br.com.gabrielcaio.ams.domain.model.Professor;
import java.util.List;

public interface ProfessorRepository {
  Boolean existsByName(String name);
  Professor findByName(String name);
  List<String> getClassGroupsNamesByProfessorName(String professorName);
  Professor save(Professor professor);
}
