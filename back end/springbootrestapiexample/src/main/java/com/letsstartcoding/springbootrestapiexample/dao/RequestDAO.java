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
	
	/*to save an Request*/
	
	public Request save(Request dri) {
		return RequestRepository.save(dri);
	}
	
	
	/* search all Request*/
	
	public List<Request> findAll(){
		return RequestRepository.findAll();
	}
	
	
	/*get an Request by id*/
	public Request findOne(Long id) {
		return RequestRepository.findOne(id);
	}
	
	
	/*delete an Request*/
	public void delete(Request dri) {
		RequestRepository.delete(dri);
	}
	
//	public static void main(String args[]) {
//		RequestDAO dao = new RequestDAO(); 
//		Long a= (long) 95;
//		Request req = dao.findOne(a);
//		System.out.println(req.getName()+"AAAAAAAA");
//	}
}
