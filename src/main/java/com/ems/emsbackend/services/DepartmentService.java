package com.ems.emsbackend.services;

import java.util.List;

import com.ems.emsbackend.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentById(Long departmentId);

    List<DepartmentDto> getAllDepartments();

    DepartmentDto updateDepartment(Long departmentId, DepartmentDto updateDepartment);

    void deleteDepartment(Long departmentId);
}
