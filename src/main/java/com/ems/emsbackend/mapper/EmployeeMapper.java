package com.ems.emsbackend.mapper;

import com.ems.emsbackend.dto.EmployeeDto;
import com.ems.emsbackend.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getContact(),
                employee.getDepartmentId(),
                employee.getAppointedDate());
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getContact(),
                employeeDto.getDepartmentId(),
                employeeDto.getAppointedDate());
    }
}
