package lk.acpt.iap_demo_api.service.impl;

import lk.acpt.iap_demo_api.dto.EmployeeDto;
import lk.acpt.iap_demo_api.entity.Employee;
import lk.acpt.iap_demo_api.repo.EmployeeRepo;
import lk.acpt.iap_demo_api.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public EmployeeDto getEmployeeById(Integer id) {
        if (employeeRepo.existsById(id)) {
            Employee search = employeeRepo.findById(id).get();
            return modelMapper.map(search, EmployeeDto.class);
        }
        return null;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employee) {
        Employee save = employeeRepo.save(modelMapper.map(employee, Employee.class));
        return  modelMapper.map(save, EmployeeDto.class);
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employee, Integer id) {
        if (employeeRepo.existsById(id)) {
            Employee update = employeeRepo.findById(id).get();

            update.setName(employee.getName());
            update.setEmail(employee.getEmail());
            update.setPosition(employee.getPosition());
            update.setSalary(employee.getSalary());

            employeeRepo.save(update);
            return modelMapper.map(update, EmployeeDto.class);
        }
        return null;

    }

    @Override
    public EmployeeDto deleteEmployee(Integer id) {
        if (employeeRepo.existsById(id)) {
            Employee delete = employeeRepo.findById(id).get();
            employeeRepo.delete(delete);
            return modelMapper.map(delete, EmployeeDto.class);
        }
        return null;

    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        List<EmployeeDto> employeeDtos = new ArrayList<>();

        for (Employee employee : employees) {
            employeeDtos.add(modelMapper.map(employee, EmployeeDto.class));
        }

        return employeeDtos;
    }
}
