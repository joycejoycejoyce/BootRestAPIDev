package net.joyce.departmentService.service.impl;

import lombok.AllArgsConstructor;
import net.joyce.departmentService.dto.DepartmentDTO;
import net.joyce.departmentService.entity.Department;
import net.joyce.departmentService.exception.DepartmentNotFoundException;
import net.joyce.departmentService.repository.DepartmentRepository;
import net.joyce.departmentService.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
        // convert DTO -> JPA entity
        Department department = modelMapper.map(departmentDTO, Department.class);

        Department saved = repository.save(department);

        DepartmentDTO savedDTO = modelMapper.map(saved, DepartmentDTO.class);

        return savedDTO;
    }

    @Override
    public DepartmentDTO getDepartmentByCode(String departmentCode) {
        Department department = repository.findByDepartmentCode(departmentCode);
        // 如果拿到的是一个 null
        if (department == null) {
            throw new DepartmentNotFoundException("departmentCode", departmentCode);
        }
        DepartmentDTO dto = modelMapper.map(department, DepartmentDTO.class);
        return dto;
    }
}
