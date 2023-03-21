package net.joagz.employees_api.models;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Employees")
public class Employee {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id", nullable = false, updatable = false)
  private String id;

  @Builder.Default
  private Boolean active = true;

  private String fullName;
  private String email;
  private Integer age;
  private String jobTitle;
  private String jobDesignation;
  private String residence;
  private String phoneNumber;
  private String documentId;
  private String creationDate;

}
