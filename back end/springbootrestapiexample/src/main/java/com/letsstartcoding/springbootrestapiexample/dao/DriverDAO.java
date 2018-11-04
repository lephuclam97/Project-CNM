package com.letsstartcoding.springbootrestapiexample.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letsstartcoding.springbootrestapiexample.model.Driver;
import com.letsstartcoding.springbootrestapiexample.repository.DriverRepository;

@Service
public class DriverDAO {
	
	@Autowired
	DriverRepository DriverRepository;
	
	/*to save an employee*/
	
	public Driver save(Driver dri) {
		return DriverRepository.save(dri);
	}
	
	
	/* search all employees*/
	
	public List<Driver> findAll(){
		return DriverRepository.findAll();
	}
	
	
	/*get an employee by id*/
	public Driver findOne(Long id) {
		return DriverRepository.findOne(id);
	}
	
	
	/*delete an employee*/
	
	public void delete(Driver dri) {
		DriverRepository.delete(dri);
	}
	

}
