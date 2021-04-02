package com.gpj.entity;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;
import org.beetl.sql.core.annotatoin.Table;


/* 
* 
* gen by beetlsql 2021-03-31
*/
@Table(name="graduation.seek")
public class Seek   {
	
	// alias
	public static final String ALIAS_id = "id";
	public static final String ALIAS_patient_id = "patient_id";
	public static final String ALIAS_days = "days";
	public static final String ALIAS_describes = "describes";
	public static final String ALIAS_illness = "illness";
	public static final String ALIAS_price = "price";
	
	private Integer id ;
	private Integer patientId ;
	private String days ;
	private String describes ;
	private String illness ;
	private BigDecimal price ;
	private Integer registrationId;
	
	public Seek() {
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
	
	public String getIllness(){
		return  illness;
	}
	public void setIllness(String illness ){
		this.illness = illness;
	}
	
	public BigDecimal getPrice(){
		return  price;
	}
	public void setPrice(BigDecimal price ){
		this.price = price;
	}
	

}
