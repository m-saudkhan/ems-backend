package com.ems.emsbackend.services.impl;

import lombok.AllArgsConstructor;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.ems.emsbackend.dto.DepartmentDto;
import com.ems.emsbackend.entity.Department;
import com.ems.emsbackend.exception.ResourceNotFoundException;
import com.ems.emsbackend.mapper.DepartmentMapper;
import com.ems.emsbackend.repository.DepartmentRepository;
import com.ems.emsbackend.services.DepartmentService;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {

        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);

        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Department is not exist with given ID : " + departmentId));

        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map((department) -> DepartmentMapper.mapToDepartmentDto(department))
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto updateDepartment) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department not exist with given ID" + departmentId));
        department.setDepartmentName(updateDepartment.getDepartmentName());
        department.setDepartmentHead(updateDepartment.getDepartmentHead());
        department.setPreviousHOD(updateDepartment.getPreviousHOD());

        Department updatedDepartmentObj = departmentRepository.save(department);

        return DepartmentMapper.mapToDepartmentDto(updatedDepartmentObj);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department not exist with given ID" + departmentId));

        departmentRepository.deleteById(departmentId);
    }
}
