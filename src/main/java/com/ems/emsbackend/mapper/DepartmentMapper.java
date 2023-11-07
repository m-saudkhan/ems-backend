package com.ems.emsbackend.mapper;

import com.ems.emsbackend.dto.DepartmentDto;
import com.ems.emsbackend.entity.Department;

public class DepartmentMapper {
    public static DepartmentDto mapToDepartmentDto(Department department) {
        return new DepartmentDto(
                department.getDepartmentId(),
                department.getDepartmentName(),
                department.getDepartmentHead(),
                department.getPreviousHOD());
    }

    public static Department mapToDepartment(DepartmentDto departmentDto) {
        return new Department(
                departmentDto.getDepartmentId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentHead(),
                departmentDto.getPreviousHOD());
    }
}
