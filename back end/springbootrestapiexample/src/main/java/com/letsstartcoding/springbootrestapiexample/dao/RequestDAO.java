package com.letsstartcoding.springbootrestapiexample.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letsstartcoding.springbootrestapiexample.model.Request;
import com.letsstartcoding.springbootrestapiexample.repository.RequestRepository;

@Service
public class RequestDAO {
	
	@Autowired
	RequestRepository RequestRepository;
	
	/*to save an employee*/
	
	public Request save(Request dri) {
		return RequestRepository.save(dri);
	}
	
	
	/* search all employees*/
	
	public List<Request> findAll(){
		return RequestRepository.findAll();
	}
	
	
	/*get an employee by id*/
	public Request findOne(Long id) {
		return RequestRepository.findOne(id);
	}
	
	
	/*delete an employee*/
	
	public void delete(Request dri) {
		RequestRepository.delete(dri);
	}
	

}
