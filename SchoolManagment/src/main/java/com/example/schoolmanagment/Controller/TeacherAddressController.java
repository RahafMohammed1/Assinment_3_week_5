package com.example.schoolmanagment.Controller;

import com.example.schoolmanagment.DTO.Teacher_AddressDto;
import com.example.schoolmanagment.Service.TeacherAddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequiredArgsConstructor
    @RequestMapping("api/v1/address")
    public class TeacherAddressController {
        private final TeacherAddressService teacherAddressService;
        @GetMapping("/getall")
        public ResponseEntity getAllTeacherAddress()
        {
            return ResponseEntity.status(200).body(teacherAddressService.getAllTeacherAddresses());
        }
        @PostMapping("/add")
        public ResponseEntity addTeacherAddress(@Valid @RequestBody Teacher_AddressDto teacherAddressDto)
        {
            teacherAddressService.addTeacherAddress(teacherAddressDto);
            return ResponseEntity.status(200).body("Teacher Address is added");
        }
        @PutMapping("/update/{id}")
        public ResponseEntity updateTeacherAddress(@PathVariable Integer id , @Valid @RequestBody Teacher_AddressDto teacherAddressDto)
        {
            teacherAddressService.updateTeacherAddress(id,teacherAddressDto);
            return ResponseEntity.status(200).body("Teacher Address is updated");
        }
        @DeleteMapping("/delete/{id}")
        public ResponseEntity deleteTeacherAddress(@PathVariable Integer id )
        {
            teacherAddressService.deleteTeacherAddress(id);
            return ResponseEntity.status(200).body("Teacher Address is deleted");
        }
    }
