package com.example.schoolmanagment.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher_AddressDto {
    private Integer teacher_id;
    @NotEmpty(message = "The area field is required")
    private String area;
    @NotEmpty(message = "The street field is required")
    private String street;
    @NotNull(message = "The buildingNumber field is required")
    private Integer buildingNumber;
}
