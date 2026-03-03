package br.com.gabrielcaio.ams.domain.service;

import br.com.gabrielcaio.ams.domain.model.Student;
import br.com.gabrielcaio.ams.domain.repository.StudentRepository;
import br.com.gabrielcaio.ams.presentation.dtos.StudentRequest;
import br.com.gabrielcaio.ams.presentation.dtos.StudentResponse;
import br.com.gabrielcaio.ams.presentation.mapper.StudentMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  private final StudentRepository repository;

  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  public StudentResponse create(StudentRequest request) {
    Student student = StudentMapper.toEntity(request);
    return StudentMapper.toResponse(repository.save(student));
  }
}
