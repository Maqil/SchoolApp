package com.school.entities;

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
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gradeAiid;

    private String gradeName;

    @OneToMany(mappedBy = "grade")
    private Set<Student> students;

    @OneToMany(mappedBy = "grade")
    private Set<Subject> subjects;

    @ManyToOne
    private Admin admin;

    // public Grade(String gradeName, Set students, Set Subjects, Admin admin) {}

    // public Grade(Object object, String string, Object object2, Admin admin2, Subject sbj1) {
    //   this.gradeName = gradeName;
    //   this.students = students;
    //   this.subjects = subjects;
    //   this.admin = admin;
    // }
}
