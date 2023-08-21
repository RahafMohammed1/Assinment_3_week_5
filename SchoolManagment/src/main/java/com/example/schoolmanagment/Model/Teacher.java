package com.example.schoolmanagment.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotEmpty(message = "The name field is required")
    @Size(min=3,message = "The Name length must be greater than 3")
    private String name;
    @NotNull(message = "The age field is required")
    @Min(value = 24,message = "the age must be greater than 24")
    private Integer age;
    @Email(message = "Error,please enter valid email")
    private String email;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Teacher_Address teacherAddress;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "teacher")
    private Set<Course> course;

}
