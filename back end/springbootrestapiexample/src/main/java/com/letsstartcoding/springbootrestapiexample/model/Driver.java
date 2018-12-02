package com.letsstartcoding.springbootrestapiexample.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
 
@Entity
@Table(name="Driver")
@EntityListeners(AuditingEntityListener.class)
public class Driver {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_driver;

	private String Password;

	private String Name;

	private String Response;

	private String Status;

	private String Waitback;
	
	private String address;

	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public Driver(Long idDriver, String password, String name, String response, String status, String waitback) {
//		super();
//		id_driver = idDriver;
//		Password = password;
//		Name = name;
//		Response = response;
//		Status = status;
//		Waitback = waitback;
//	}
	

	public Long getId_driver() {
		return id_driver;
	}

	public void setId_driver(Long id_driver) {
		this.id_driver = id_driver;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	

	public String getResponse() {
		return Response;
	}

	public void setResponse(String response) {
		Response = response;
	}
	

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}


	public String getWaitback() {
		return Waitback;
	}

	public void setWaitback(String waitback) {
		Waitback = waitback;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
}
