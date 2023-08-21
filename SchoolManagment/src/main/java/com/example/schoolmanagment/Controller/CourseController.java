package com.example.schoolmanagment.Controller;

import com.example.schoolmanagment.DTO.Teacher_AddressDto;
import com.example.schoolmanagment.Model.Course;
import com.example.schoolmanagment.Service.CourseService;
import com.example.schoolmanagment.Service.TeacherAddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/course")
public class CourseController {
    private final CourseService courseService;
    @GetMapping("/getall")
    public ResponseEntity getAllCourse()
    {
        return ResponseEntity.status(200).body(courseService.getAllCourse());
    }
    @PostMapping("/add")
    public ResponseEntity addCourse(@Valid @RequestBody Course course)
    {
        courseService.addCourse(course);
        return ResponseEntity.status(200).body("Teacher Course is added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id , @Valid @RequestBody Course course)
    {
        courseService.updateCourse(id, course);
        return ResponseEntity.status(200).body("Teacher Course is updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id )
    {
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body("Teacher Course is deleted");
    }
    @PutMapping("/assign/{tid}/{cid}")
    public ResponseEntity assignTeacherToCourse(@PathVariable Integer tid,@PathVariable Integer cid)
    {
        courseService.assignTeacherToCourse(tid,cid);
        return ResponseEntity.status(200).body(" Course is assign");
    }
}
