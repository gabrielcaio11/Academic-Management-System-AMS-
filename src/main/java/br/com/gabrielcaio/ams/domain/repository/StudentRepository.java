package br.com.gabrielcaio.ams.domain.repository;

import br.com.gabrielcaio.ams.domain.model.Student;

public interface StudentRepository {
  Boolean existsByFullName(String name);
  Student findByFullName(String name);
  Student save(Student student);
}
