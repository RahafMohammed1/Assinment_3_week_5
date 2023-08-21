package com.example.schoolmanagment.Service;

import com.example.schoolmanagment.Api.ApiException;
import com.example.schoolmanagment.Model.Teacher;
import com.example.schoolmanagment.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id, Teacher teacher) {
        Teacher teacher1 = teacherRepository.findTeacherById(id);

        if (teacher1 == null) {
            throw new ApiException("The teacher not found");
        }
        teacher1.setAge(teacher.getAge());
        teacher1.setName(teacher.getName());
        teacher1.setEmail(teacher.getEmail());
        teacherRepository.save(teacher1);
    }

    public void deleteTeacher(Integer id) {
        Teacher teacher1 = teacherRepository.findTeacherById(id);

        if (teacher1 == null) {
            throw new ApiException("The teacher not found");
        }
        teacherRepository.delete(teacher1);
    }

    public Teacher teacherDetails(Integer id) {
        return teacherRepository.findTeacherById(id);
    }
}
