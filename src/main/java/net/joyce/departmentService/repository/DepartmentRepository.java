package net.joyce.departmentService.repository;

import net.joyce.departmentService.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    public Department findByDepartmentCode(String departmentCode);
}
