package br.com.gabrielcaio.ams.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "grades")
public class Grade {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(optional = false)
  @JoinColumn(name = "enrollment_id", nullable = false, unique = true)
  private Enrollment enrollment;

  @Column(nullable = false)
  private Double value;

  protected Grade() {
  }

  public Grade(Enrollment enrollment, Double value) {
    this.enrollment = enrollment;
    this.value = value;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }

  public Enrollment getEnrollment() {
    return enrollment;
  }

  public void setEnrollment(Enrollment enrollment) {
    this.enrollment = enrollment;
  }
}
