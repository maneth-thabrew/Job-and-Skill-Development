package lk.acpt.iap_demo_api.repo;

import lk.acpt.iap_demo_api.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
