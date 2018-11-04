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
@Table(name="Request")
@EntityListeners(AuditingEntityListener.class)
public class Request {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_request;
	
	private Long id_driver;
	private String Name;
	private String Phone;
	@NotBlank
	private String Address;
	private String Note;
	private String Position;
	private String Status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date Time;
	
	
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId_request() {
		return id_request;
	}

	public void setId_request(Long id_request) {
		this.id_request = id_request;
	}

	public Long getId_driver() {
		return id_driver;
	}

	public void setId_driver(Long id_driver) {
		this.id_driver = id_driver;
	}




	public String getName() {
		return Name;
	}



	public void setName(String name) {
		Name = name;
	}



	public String getPhone() {
		return Phone;
	}



	public void setPhone(String phone) {
		Phone = phone;
	}



	public String getAddress() {
		return Address;
	}



	public void setAddress(String address) {
		Address = address;
	}



	public String getNote() {
		return Note;
	}



	public void setNote(String note) {
		Note = note;
	}



	public Date getTime() {
		return Time;
	}



	public void setTime(Date time) {
		Time = time;
	}



	public String getPosition() {
		return Position;
	}



	public void setPosition(String position) {
		Position = position;
	}



	public String getStatus() {
		return Status;
	}



	public void setStatus(String status) {
		Status = status;
	}
	
	
	
	
	
}
