package com.example.schoolmanagment.Service;

import com.example.schoolmanagment.Api.ApiException;
import com.example.schoolmanagment.Model.Course;
import com.example.schoolmanagment.Model.Teacher;
import com.example.schoolmanagment.Model.Teacher_Address;
import com.example.schoolmanagment.Repository.CourseRepository;
import com.example.schoolmanagment.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    public List<Course> getAllCourse()
    {
        return courseRepository.findAll();
    }
    public void addCourse(Course course)
    {
        courseRepository.save(course);
    }
    public void updateCourse( Integer id,Course course)
    {
        Course course1=courseRepository.findCourseById(id);
        if(course1==null)
        {
            throw new ApiException("not found");
        }
        course1.setName(course.getName());
        courseRepository.save(course1);
    }

    public void deleteCourse(Integer id){
        Course course1=courseRepository.findCourseById(id);
        Teacher teacher=teacherRepository.findTeacherById(course1.getTeacher().getId());
        if(course1==null)
        {
            throw new ApiException("not found");
        }
        courseRepository.delete(course1);
    }

    public void assignTeacherToCourse(Integer teacherId,Integer courseId)
    {
        Course course1=courseRepository.findCourseById(courseId);
        Teacher teacher=teacherRepository.findTeacherById(teacherId);
        if(course1==null||teacherId==null)
        {
            throw new ApiException("Can't assign");
        }

        course1.setTeacher(teacher);
        courseRepository.save(course1);
    }


}
