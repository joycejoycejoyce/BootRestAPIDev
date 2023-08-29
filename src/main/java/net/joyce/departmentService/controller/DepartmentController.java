package net.joyce.departmentService.controller;

import net.joyce.departmentService.dto.DepartmentDTO;
import net.joyce.departmentService.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    //
    @PostMapping
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO dto) {
        DepartmentDTO saved = departmentService.saveDepartment(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDTO> findDepartment(@PathVariable("department-code") String departmentCode) {
        DepartmentDTO dto = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
