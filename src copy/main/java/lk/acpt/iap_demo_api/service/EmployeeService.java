package lk.acpt.iap_demo_api.service;

import lk.acpt.iap_demo_api.dto.EmployeeDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeeService {

    EmployeeDto getEmployeeById(Integer id);

    EmployeeDto createEmployee(EmployeeDto employee);

    EmployeeDto updateEmployee(EmployeeDto employee, Integer id);

    EmployeeDto deleteEmployee(Integer id);

    List<EmployeeDto> getAllEmployees();

}
