package casper.hrmsApp.api.controllers;

import casper.hrmsApp.business.abstracts.EmployeeService;
import casper.hrmsApp.core.utilities.results.DataResult;
import casper.hrmsApp.core.utilities.results.Result;
import casper.hrmsApp.entities.concretes.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.add(employee));
    }
    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(employeeService.getAll());
    }
}
