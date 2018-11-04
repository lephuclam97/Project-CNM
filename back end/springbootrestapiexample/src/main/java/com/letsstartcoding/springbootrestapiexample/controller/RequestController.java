package com.letsstartcoding.springbootrestapiexample.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letsstartcoding.springbootrestapiexample.dao.RequestDAO;
import com.letsstartcoding.springbootrestapiexample.model.Request;

@RestController
@RequestMapping("/Request")
public class RequestController{
	
	@Autowired
	RequestDAO DAO;
	
	/* to save an employee*/
	@PostMapping("/add")
	public Request createEmployee(@Valid @RequestBody Request emp) {
		return DAO.save(emp);
	}
	
	/*get all employees*/
	@GetMapping("/getall")
	public List<Request> getAllRequest(){
		return DAO.findAll();
	}
//	
//	/*get employee by empid*/
//	@GetMapping("/employees/{id}")
//	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") Long empid){
//		
//		Employee emp=employeeDAO.findOne(empid);
//		
//		if(emp==null) {
//			return ResponseEntity.notFound().build();
//		}
//		return ResponseEntity.ok().body(emp);
//		
//	}
//	
//	
//	/*update an employee by empid*/
//	@PutMapping("/employees/{id}")
//	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Long empid,@Valid @RequestBody Employee empDetails){
//		
//		Employee emp=employeeDAO.findOne(empid);
//		if(emp==null) {
//			return ResponseEntity.notFound().build();
//		}
//		
//		emp.setName(empDetails.getName());
//		emp.setDesignation(empDetails.getDesignation());
//		emp.setExpertise(empDetails.getExpertise());
//		
//		Employee updateEmployee=employeeDAO.save(emp);
//		return ResponseEntity.ok().body(updateEmployee);
//		
//		
//		
//	}
//	
//	/*Delete an employee*/
//	@DeleteMapping("/employees/{id}")
//	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") Long empid){
//		
//		Employee emp=employeeDAO.findOne(empid);
//		if(emp==null) {
//			return ResponseEntity.notFound().build();
//		}
//		employeeDAO.delete(emp);
//		
//		return ResponseEntity.ok().build();
//		
//		
//	}
	
	

}
