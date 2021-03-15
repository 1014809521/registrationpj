package com.gpj.entity;
import java.math.*;

import org.beetl.sql.core.annotatoin.Table;


/* 
* 
* gen by beetlsql 2021-03-08
*/
@Table(name="graduation.consultation")
public class Consultation   {
	
	// alias
	public static final String ALIAS_id = "id";
	public static final String ALIAS_patient_id = "patient_id";
	public static final String ALIAS_registration_id = "registration_id";
	public static final String ALIAS_days = "days";
	public static final String ALIAS_describes = "describes";
	public static final String ALIAS_price = "price";
	
	private Integer id ;
	private Integer patientId ;
	private Integer registrationId ;
	private String days ;
	private String describes ;
	private BigDecimal price ;
	
	public Consultation() {
	}
	
	public Integer getId(){
		return  id;
	}
	public void setId(Integer id ){
		this.id = id;
	}
	
	public Integer getPatientId(){
		return  patientId;
	}
	public void setPatientId(Integer patientId ){
		this.patientId = patientId;
	}
	
	public Integer getRegistrationId(){
		return  registrationId;
	}
	public void setRegistrationId(Integer registrationId ){
		this.registrationId = registrationId;
	}
	
	public String getDays(){
		return  days;
	}
	public void setDays(String days ){
		this.days = days;
	}
	
	public String getDescribes(){
		return  describes;
	}
	public void setDescribes(String describes ){
		this.describes = describes;
	}
	
	public BigDecimal getPrice(){
		return  price;
	}
	public void setPrice(BigDecimal price ){
		this.price = price;
	}
	

}
