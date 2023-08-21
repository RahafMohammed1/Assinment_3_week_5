package com.example.schoolmanagment.Service;

import com.example.schoolmanagment.Api.ApiException;
import com.example.schoolmanagment.DTO.Teacher_AddressDto;
import com.example.schoolmanagment.Model.Teacher;
import com.example.schoolmanagment.Model.Teacher_Address;
import com.example.schoolmanagment.Repository.TeacherAddressRepository;
import com.example.schoolmanagment.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TeacherAddressService {
    private final TeacherRepository teacherRepository;
    private final TeacherAddressRepository teacherAddressRepository;

    public List<Teacher_Address> getAllTeacherAddresses()
    {
        return teacherAddressRepository.findAll();
    }
    public void addTeacherAddress(Teacher_AddressDto teacherAddressDto)
    {
        Teacher teacher=teacherRepository.findTeacherById(teacherAddressDto.getTeacher_id());
        if(teacher==null)
        {
            throw new ApiException("please enter The teacher info first ");
        }
        Teacher_Address teacher_address=new Teacher_Address(null,teacherAddressDto.getArea(),teacherAddressDto.getStreet(),teacherAddressDto.getBuildingNumber(),teacher);
        teacherAddressRepository.save(teacher_address);
    }
    public void updateTeacherAddress(Integer id,Teacher_AddressDto teacherAddressDto)
    {
        Teacher_Address teacherAddress=teacherAddressRepository.findTeacher_AddressById(id);
        if(teacherAddress==null)
        {
            throw new ApiException("The Teacher Address not found ");
        }
        teacherAddress.setArea(teacherAddressDto.getArea());
        teacherAddress.setStreet(teacherAddressDto.getStreet());
        teacherAddress.setBuildingNumber(teacherAddressDto.getBuildingNumber());
        teacherAddressRepository.save(teacherAddress);
    }

    public void deleteTeacherAddress(Integer id) {
        Teacher_Address teacherAddress1 = teacherAddressRepository.findTeacher_AddressById(id);
        if(teacherAddress1==null)
        {
            throw new ApiException("The Teacher Address not found ");
        }
        Teacher teacher=teacherRepository.findTeacherById(teacherAddress1.getTeacher().getId());
        teacher.setTeacherAddress(null);
        teacherRepository.save(teacher);
        teacherAddressRepository.delete(teacherAddress1);
    }


}
