package lk.acpt.iap_demo_api.controller;

import lk.acpt.iap_demo_api.dto.EmployeeDto;
import lk.acpt.iap_demo_api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto employee = employeeService.createEmployee(employeeDto);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(employee, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> allEmployees = employeeService.getAllEmployees();
        return ResponseEntity.ok(allEmployees);

    }

    @GetMapping("/search/{id}")
    public ResponseEntity<EmployeeDto> searchEmployee(@PathVariable Integer id) {
        EmployeeDto employeeById = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeById);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeDto> deleteEmployeeById(@PathVariable Integer id) {
        EmployeeDto deleteEmployee = employeeService.deleteEmployee(id);
        return ResponseEntity.ok(deleteEmployee);

    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable Integer id) {
        EmployeeDto updateEmployee = employeeService.updateEmployee(employeeDto, id);
        return ResponseEntity.ok(updateEmployee);
    }

}
