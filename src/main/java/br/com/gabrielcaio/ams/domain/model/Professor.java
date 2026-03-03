package br.com.gabrielcaio.ams.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "professors")
public class Professor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false, unique = true, name = "employee_code")
  private String employeeCode;

  @OneToMany(mappedBy = "professor")
  private Set<ClassGroup> classes = new HashSet<>();

  protected Professor() {
  }

  public Professor(String name, String employeeCode) {
    this.name = name;
    this.employeeCode = employeeCode;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmployeeCode() {
    return employeeCode;
  }

  public void setEmployeeCode(String employeeCode) {
    this.employeeCode = employeeCode;
  }

  public Set<ClassGroup> getClasses() {
    return classes;
  }

  public void setClasses(Set<ClassGroup> classes) {
    this.classes = classes;
  }
}