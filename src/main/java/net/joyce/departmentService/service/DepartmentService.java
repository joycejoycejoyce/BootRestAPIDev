package net.joyce.departmentService.service;

import net.joyce.departmentService.dto.DepartmentDTO;

public interface DepartmentService {
    DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);

    DepartmentDTO getDepartmentByCode(String departmentCode);
}
