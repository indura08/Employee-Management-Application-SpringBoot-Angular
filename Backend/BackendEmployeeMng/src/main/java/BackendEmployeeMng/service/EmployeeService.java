package BackendEmployeeMng.service;

import BackendEmployeeMng.model.Employee;
import BackendEmployeeMng.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(int id){
        employeeRepo.deleteById(id);
    }

    public Employee findById(int id){
        return employeeRepo.findById(id).get();
    }

    public List<Employee> findByJobTitle(String jobTitle){
        return employeeRepo.findByJobTitle(jobTitle);
    }



}
