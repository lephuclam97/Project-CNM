package com.letsstartcoding.springbootrestapiexample.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letsstartcoding.springbootrestapiexample.model.Driver;
import com.letsstartcoding.springbootrestapiexample.repository.DriverRepository;

@Service
public class DriverDAO {
	
	@Autowired
	DriverRepository DriverRepository;
	
/*to save an driver*/
	
	public Driver save(Driver dri) {
		 try {
			 	MessageDigest md = MessageDigest.getInstance("MD5");
		        byte[] passBytes = dri.getPassword().getBytes();
		        md.reset();
		        byte[] digested = md.digest(passBytes);
		        StringBuffer sb = new StringBuffer();
		        for(int i=0;i<digested.length;i++){
		            sb.append(Integer.toHexString(0xff & digested[i]));
		        }
		        dri.setPassword(sb.toString());
		    } catch (NoSuchAlgorithmException ex) {
		    }
		return DriverRepository.save(dri);
	}
	
	
	/* search all driver*/
	
	public List<Driver> findAll(){
		return DriverRepository.findAll();
	}
	
	
	/*get an driver by id*/
	public Driver findOne(Long id) {
		return DriverRepository.findOne(id);
	}
	
	
	/*delete an driver*/
	
	public void delete(Driver dri) {
		DriverRepository.delete(dri);
	}
	
	
	

}
