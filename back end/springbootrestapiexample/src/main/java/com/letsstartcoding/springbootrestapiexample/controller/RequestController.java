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

import com.letsstartcoding.springbootrestapiexample.dao.RequestDAO;
import com.letsstartcoding.springbootrestapiexample.model.Driver;
import com.letsstartcoding.springbootrestapiexample.model.Request;

@RestController
@RequestMapping("/Request")
public class RequestController{
	
	@Autowired
	RequestDAO DAO;
	
	/* to save an Request*/
	@PostMapping("/add")
	public Request createEmployee(@Valid @RequestBody Request req) {
		req.setPosition("Not yet");
		req.setStatus("Waiting..");
		return DAO.save(req);
	}
	
	/*get all Request*/
	@GetMapping("/getall")
	public List<Request> getAllRequest(){
		List <Request> listReq= DAO.findAll();
		Collections.sort(listReq);
		
		
		return DAO.findAll();
	}

//	/*get Request by id*/
	@GetMapping("/{id}")
	public ResponseEntity<Request> getRequestById(@PathVariable(value="id") Long id){
		
		Request req = DAO.findOne(id);
		
		if(req==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(req);
	}
	
	/*update a position of Request by id request*/
	@PutMapping("/position/{id}")
	public ResponseEntity<Request> updatePosition(@PathVariable(value="id") Long id){
		
		Request req = DAO.findOne(id);
		if(req==null) {
			return ResponseEntity.notFound().build();
		}
		
		req.setPosition("Done");
		
		Request updateRequest = DAO.save(req);
		return ResponseEntity.ok().body(updateRequest);	
	}

	/*update a position of Request by id request*/
	@PutMapping("/geocoding/{id}/{content}")
	public ResponseEntity<Request> updateGeocoding(@PathVariable(value="id") Long id, @PathVariable(value="content") String content){
		
		Request req = DAO.findOne(id);
		if(req==null) {
			return ResponseEntity.notFound().build();
		}
		
		req.setGeocode(content);
		
		Request updateRequest = DAO.save(req);
		return ResponseEntity.ok().body(updateRequest);	
	}
	
	/*update a driver of Request by id request*/
	@PutMapping("/driver/{id}")
	public ResponseEntity<Request> updateDriver(@PathVariable(value="id") Long id,@Valid @RequestBody Long id_driver){
		
		Request req = DAO.findOne(id);
		if(req==null) {
			return ResponseEntity.notFound().build();
		}
		
		req.setId_driver(id_driver);
		
		Request updateRequest = DAO.save(req);
		return ResponseEntity.ok().body(updateRequest);	
	}
	
	/*update a status of Request by id request*/
	@PutMapping("/statusSuccess/{id}")
	public ResponseEntity<Request> updateStatus(@PathVariable(value="id") Long id){
		
		Request req = DAO.findOne(id);
		if(req==null) {
			return ResponseEntity.notFound().build();
		}
		
		req.setStatus("Success");
		
		Request updateRequest = DAO.save(req);
		return ResponseEntity.ok().body(updateRequest);	
	}
	
	@PutMapping("/statusMove/{id}")
	public ResponseEntity<Request> updateStatus2(@PathVariable(value="id") Long id){
		
		Request req = DAO.findOne(id);
		if(req==null) {
			return ResponseEntity.notFound().build();
		}
		
		req.setStatus("Moving..");
		
		Request updateRequest = DAO.save(req);
		return ResponseEntity.ok().body(updateRequest);	
	}

}
