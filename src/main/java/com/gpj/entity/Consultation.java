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
	public static final String ALIAS_doctor_id = "doctor_id";
	public static final String ALIAS_days = "days";
	public static final String ALIAS_describes = "describes";
	public static final String ALIAS_price = "price";
	public static final String ALIAS_reply = "reply";
	
	private Integer id ;
	private Integer patientId ;
	private Integer doctorId ;
	private String days ;
	private String describes ;
	private BigDecimal price ;
	private String reply;
	
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
	
	public Integer getDoctorId(){
		return  doctorId;
	}
	public void setDoctorId(Integer doctorId ){
		this.doctorId = doctorId;
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
	public String getReply(){
		return  reply;
	}
	public void setReply(String reply ){
		this.reply = reply;
	}

}
