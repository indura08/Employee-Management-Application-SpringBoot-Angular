package BackendEmployeeMng.contoller;

import BackendEmployeeMng.model.Employee;
import BackendEmployeeMng.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService1){
        this.employeeService = employeeService1;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id){ //pathvaribale eka ehmath denwa nattnm mn klin krpu widi waltath denwa awlk nha eka khm unath
        Employee emp = employeeService.findById(id);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> createNewEmployee(@RequestBody Employee employee){
        Employee emp = employeeService.addEmployee(employee);
        return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee emp = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    } //methna update eke podi kossak thiynwa employeecode ekath ekala update krnna giyma podi case ekk enwa , eka porject eka anthimt debug krnna

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id){  //muuth return knne nattnm ResponseEntity eke ? lakuna daala nikan innwa
        Employee emp = employeeService.findById(id);
        if(emp != null){
            employeeService.deleteEmployee(id);
            return new ResponseEntity<>("Employee deleted Successfully!" , HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Employee Couldnt be found , please check again" , HttpStatus.NOT_FOUND);
        }
    }
}
