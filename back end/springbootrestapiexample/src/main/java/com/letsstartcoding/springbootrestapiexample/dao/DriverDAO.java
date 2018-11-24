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
	
/*to save an driver*/
	
	public Driver save(Driver dri) {
//		 try {
//			 	MessageDigest md = MessageDigest.getInstance("MD5");
//		        byte[] passBytes = dri.getPassword().getBytes();
//		        md.reset();
//		        byte[] digested = md.digest(passBytes);
//		        StringBuffer sb = new StringBuffer();
//		        for(int i=0;i<digested.length;i++){
//		            sb.append(Integer.toHexString(0xff & digested[i]));
//		        }
//		        dri.setPassword(sb.toString());
//		    } catch (NoSuchAlgorithmException ex) {
//		    }
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
	
	/*get an driver by id*/
//	public Driver findAcc(String name, String pass) {
//		List<Driver> listDri = DriverRepository.findAll();
//		Driver dri = new Driver();
//		dri= null;
//		for(int i=0;i<listDri.size();i++) {
//			if(listDri.get(i).getName()== name && listDri.get(i).getPassword()==pass) {
//				dri = listDri.get(i);
//			}
//		}
//		return dri;
//	}
	
	
	public Driver findname(String name) {
		List<Driver> listDri = DriverRepository.findAll();
		Driver dri = new Driver();
		dri= null;
		for(int i=0;i<listDri.size();i++) {
			if(listDri.get(i).getName()== name) {
				dri = listDri.get(i);
			}
		}
		return dri;
	}
	
	
	/*delete an driver*/
	
	public void delete(Driver dri) {
		DriverRepository.delete(dri);
	}
	
	public static void main(String[] args) {
//	
//		Driver a =new Driver();
//		long x=2;
//		a = DAO.findOne(x);
//		System.out.println("n");
	}
	

}
