package com.school.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student extends User {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Integer studentAiid;

    // @ManyToOne
    // private Enrollment enrollment;

    @ManyToOne
    private Grade grade;

    @ManyToOne
    private Admin admin;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Set<Assignment> assignments;

    public Student (String username, String email, String password, Boolean enabled, String firstName, String lastName, Grade grade, Set assignments, Admin admin) {
      super(username, email, password, firstName, lastName, enabled, new Role(4L));
      this.grade = grade;
      this.assignments = assignments;
      this.admin = admin
    }
}
