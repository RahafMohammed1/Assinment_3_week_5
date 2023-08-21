package com.example.schoolmanagment.Repository;

import com.example.schoolmanagment.Model.Teacher_Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherAddressRepository extends JpaRepository<Teacher_Address,Integer> {
    Teacher_Address findTeacher_AddressById(Integer id);
}
