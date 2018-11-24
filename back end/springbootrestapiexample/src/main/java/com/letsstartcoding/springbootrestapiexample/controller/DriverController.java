package com.letsstartcoding.springbootrestapiexample.controller;

import java.util.ArrayList;
import java.util.Collections;
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

import com.letsstartcoding.springbootrestapiexample.dao.DriverDAO;
import com.letsstartcoding.springbootrestapiexample.model.Driver;

@RestController
@RequestMapping("/Driver")
public class DriverController {

	@Autowired
	DriverDAO DAO;
	
	/* to save a Driver*/
	@PostMapping("/add")
	public Driver createEmployee(@Valid @RequestBody Driver emp) {
		return DAO.save(emp);
	}
	
	/*get all Driver*/
	@GetMapping("/getall")
	public List<Driver> getAllDriver(){		
		return DAO.findAll();
	}
	
	/*get Driver by id*/
	@GetMapping("/{id}")
	public ResponseEntity<Driver> getDriverById(@PathVariable(value="id") Long id){
		
		Driver dri = DAO.findOne(id);
		
		if(dri==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(dri);
		
	}
	
	@GetMapping("/login/{name}/{pass}")
	public ResponseEntity<Driver> loginDriver(@PathVariable(value="name") String name, @PathVariable(value="pass") String pass ){
		
		List<Driver> listDri = DAO.findAll();
		Driver dri = new Driver();
		dri = null;
		for(int i=0;i<listDri.size();i++) {
			if(name.equals(listDri.get(i).getName())==true && pass.equals(listDri.get(i).getPassword())==true) {
				dri = listDri.get(i);
			}
		}
		
		if(dri==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(dri);
		
	}
	
	
	/*update an Driver by id*/
	@PutMapping("/status/{id}")
	public ResponseEntity<Driver> updateStatus(@PathVariable(value="id") Long id,@Valid @RequestBody String status){
		
		Driver dri= DAO.findOne(id);
		if(dri==null) {
			return ResponseEntity.notFound().build();
		}
		
		dri.setStatus(status);
		
		Driver updateDriver= DAO.save(dri);
		return ResponseEntity.ok().body(updateDriver);
		
	}
	
	/*Delete a Driver by id*/
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Driver> deleteEmployee(@PathVariable(value="id") Long empid){
		
		Driver dri= DAO.findOne(empid);
		if(dri==null) {
			return ResponseEntity.notFound().build();
		}
		DAO.delete(dri);
		
		return ResponseEntity.ok().build();
	}

}
