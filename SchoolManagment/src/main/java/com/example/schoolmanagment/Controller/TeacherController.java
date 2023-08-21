package com.example.schoolmanagment.Controller;

import com.example.schoolmanagment.Model.Teacher;
import com.example.schoolmanagment.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;
    @GetMapping("/getall")
    public ResponseEntity getAllTeacher()
    {
        return ResponseEntity.status(200).body(teacherService.getAllTeacher());
    }
    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher)
    {
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body("Teacher is added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id , @Valid @RequestBody Teacher teacher)
    {
        teacherService.updateTeacher(id,teacher);
        return ResponseEntity.status(200).body("Teacher is updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id )
    {
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body("Teacher is deleted");
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity teacherDetail(@PathVariable Integer id)
    {
        return ResponseEntity.status(200).body(teacherService.teacherDetails(id));
    }
}
