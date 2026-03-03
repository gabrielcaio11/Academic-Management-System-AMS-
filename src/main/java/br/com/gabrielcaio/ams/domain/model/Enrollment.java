package br.com.gabrielcaio.ams.domain.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.time.LocalDate;

@Entity
@Table(name = "enrollments",
    uniqueConstraints = @UniqueConstraint(columnNames = {"student_id", "class_group_id"}))
public class Enrollment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(optional = false)
  @JoinColumn(name = "student_id", nullable = false)
  private Student student;

  @ManyToOne(optional = false)
  @JoinColumn(name = "class_group_id", nullable = false)
  private ClassGroup classGroup;

  @Column(nullable = false)
  private LocalDate enrollmentDate;

  @OneToOne(mappedBy = "enrollment", cascade = CascadeType.ALL, orphanRemoval = true)
  private Grade grade;

  protected Enrollment() {
  }

  public Enrollment(Student student, ClassGroup classGroup, LocalDate enrollmentDate) {
    this.student = student;
    this.classGroup = classGroup;
    this.enrollmentDate = enrollmentDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public ClassGroup getClassGroup() {
    return classGroup;
  }

  public void setClassGroup(ClassGroup classGroup) {
    this.classGroup = classGroup;
  }

  public LocalDate getEnrollmentDate() {
    return enrollmentDate;
  }

  public void setEnrollmentDate(LocalDate enrollmentDate) {
    this.enrollmentDate = enrollmentDate;
  }

  public Grade getGrade() {
    return grade;
  }

  public void setGrade(Grade grade) {
    this.grade = grade;
  }
}
