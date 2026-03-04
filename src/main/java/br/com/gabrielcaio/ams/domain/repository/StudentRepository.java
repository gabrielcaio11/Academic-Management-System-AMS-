package br.com.gabrielcaio.ams.domain.repository;

import br.com.gabrielcaio.ams.domain.model.Student;

public interface StudentRepository {
  Boolean existsByName(String name);
  Student findByName(String name);
  Student save(Student student);
}
