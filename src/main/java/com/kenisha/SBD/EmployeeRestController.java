package com.kenisha.SBD;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequestMapping("/kenisha_api/v1")
public class EmployeeRestController {
	  @Autowired
	    private EmployeeRepository employeerepository;
	
	  @GetMapping("/employees")
	  public List<Employee> getAllEmployees(Model model) {
	   	
	  return this.employeerepository.findAll();
	 }
	 // get employee by id
	  @GetMapping("/employees/{id}")
	  public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
	    throws ResourceNotFoundException {
	    Employee employee = employeerepository.findById(employeeId)
	     .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
	    return ResponseEntity.ok().body(employee);
	  }
	  @PostMapping("/employees")
	  public Employee createEmployee(@Valid @RequestBody Employee employee) {
	 	 return employeerepository.save(employee);
	  }
	// PUT : UPDATE EMPLOYEE DETAILS
		@PutMapping("/employees/{id}")
		public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId, 
				@Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
			Employee employee = employeerepository.findById(employeeId)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
			employee.setEmail(employeeDetails.getEmail());
			employee.setFirstName(employeeDetails.getFirstName());
			employee.setLastName(employeeDetails.getLastName());
			employee.setPassword(employeeDetails.getPassword());
			
			final Employee updatedEmployee = employeerepository.save(employee);
			System.out.println("UPDATE employee " + employeeId);
			return ResponseEntity.ok(updatedEmployee);
		}

		// DELETE : DELETE EMPLOYEE BY ID
		@DeleteMapping("/employees/{id}")
		public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
			Employee employee = employeerepository.findById(employeeId)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
			employeerepository.delete(employee);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			System.out.println("DELETE employee " + employeeId);
			return response;
		}
	  
}


