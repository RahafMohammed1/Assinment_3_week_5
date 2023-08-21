package com.example.schoolmanagment.Repository;

import com.example.schoolmanagment.Model.Course;
import com.example.schoolmanagment.Model.Teacher_Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
 Course findCourseById(Integer id);
}
