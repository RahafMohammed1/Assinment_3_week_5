package com.example.schoolmanagment.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotEmpty(message = "The name field is required")
    private String name;

    @ManyToOne
    @JoinColumn(name = "teacher_id",referencedColumnName = "id" )
    @JsonIgnore
    private Teacher teacher;
}
