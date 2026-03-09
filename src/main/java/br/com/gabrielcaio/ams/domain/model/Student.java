package br.com.gabrielcaio.ams.domain.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, name = "full_name")
  private String fullName;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false, unique = true, name = "registration_number")
  private String registrationNumber;

  @Column(nullable = false, name = "birth_date")
  private LocalDate birthDate;

  @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Enrollment> enrollments = new HashSet<>();

  protected Student() {
  }

  public Student(String fullName, String email, String registrationNumber, LocalDate birthDate) {
    this.fullName = fullName;
    this.email = email;
    this.registrationNumber = registrationNumber;
    this.birthDate = birthDate;
  }

  public Long getId() {
    return id;
  }

  public String getFullName() {
    return fullName;
  }

  public String getEmail() {
    return email;
  }

  public String getRegistrationNumber() {
    return registrationNumber;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public Set<Enrollment> getEnrollments() {
    return enrollments;
  }
}