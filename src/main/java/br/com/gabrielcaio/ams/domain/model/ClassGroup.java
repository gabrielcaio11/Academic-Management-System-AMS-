package br.com.gabrielcaio.ams.domain.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "class_groups")
public class ClassGroup {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  private String semester;

  @ManyToOne(optional = false)
  @JoinColumn(name = "course_id", nullable = false)
  private Course course;

  @ManyToOne(optional = false)
  @JoinColumn(name = "professor_id", nullable = false)
  private Professor professor;

  @OneToMany(mappedBy = "classGroup", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Enrollment> enrollments = new HashSet<>();

  @Column(nullable = false)
  private Integer maxStudents;

  public ClassGroup() {
  }

  public ClassGroup(String name, String semester, Course course, Professor professor,
      Integer maxStudents) {
    this.name = name;
    this.semester = semester;
    this.course = course;
    this.professor = professor;
    this.maxStudents = maxStudents;
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

  public String getSemester() {
    return semester;
  }

  public void setSemester(String semester) {
    this.semester = semester;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public Professor getProfessor() {
    return professor;
  }

  public void setProfessor(Professor professor) {
    this.professor = professor;
  }

  public Set<Enrollment> getEnrollments() {
    return enrollments;
  }

  public void setEnrollments(Set<Enrollment> enrollments) {
    this.enrollments = enrollments;
  }

  public Integer getMaxStudents() {
    return maxStudents;
  }

  public void setMaxStudents(Integer maxStudents) {
    this.maxStudents = maxStudents;
  }
}
