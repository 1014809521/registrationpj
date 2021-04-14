package com.gpj.entity;
import java.math.*;
import java.util.Date;

import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.beetl.sql.core.annotatoin.Table;
import org.springframework.format.annotation.DateTimeFormat;


/* 
* 
* gen by beetlsql 2021-03-08
*/
@Data
@Table(name="graduation.registration")
public class Registration   {
	
	// alias
	public static final String ALIAS_id = "id";
	public static final String ALIAS_doctor_id = "doctor_id";
	public static final String ALIAS_patient_id = "patient_id";
	public static final String ALIAS_expenses = "expenses";
	public static final String ALIAS_status = "status";
	public static final String ALIAS_time = "time";
	
	/*
	主键
	*/
	private Integer id ;
	/*
	医生id
	*/
	private Integer doctorId ;
	/*
	患者id
	*/
	private Integer patientId ;
	/*
	门诊费
	*/
	private BigDecimal expenses ;
	/*
	就诊状态
	*/
	private String status ;
	/*
	挂号时间
	*/
	private Date time ;



	/*
	患者名称
	 */
	private String patientName;

	/*
	医生名称
	 */
	private String doctorName;

	/*
	部门名称
	 */
	private String department;
	
	public Registration() {
	}
	
	/**
	* 主键
	*@return 
	*/
	public Integer getId(){
		return  id;
	}
	/**
	* 主键
	*@param  id
	*/
	public void setId(Integer id ){
		this.id = id;
	}
	
	/**
	* 医生id
	*@return 
	*/
	public Integer getDoctorId(){
		return  doctorId;
	}
	/**
	* 医生id
	*@param  doctorId
	*/
	public void setDoctorId(Integer doctorId ){
		this.doctorId = doctorId;
	}
	
	/**
	* 患者id
	*@return 
	*/
	public Integer getPatientId(){
		return  patientId;
	}
	/**
	* 患者id
	*@param  patientId
	*/
	public void setPatientId(Integer patientId ){
		this.patientId = patientId;
	}
	
	/**
	* 门诊费
	*@return 
	*/
	public BigDecimal getExpenses(){
		return  expenses;
	}
	/**
	* 门诊费
	*@param  expenses
	*/
	public void setExpenses(BigDecimal expenses ){
		this.expenses = expenses;
	}
	
	/**
	* 就诊状态
	*@return 
	*/
	public String getStatus(){
		return  status;
	}
	/**
	* 就诊状态
	*@param  status
	*/
	public void setStatus(String status ){
		this.status = status;
	}
	
	/**
	* 挂号时间
	*@return 
	*/
	public Date getTime(){
		return  time;
	}
	/**
	* 挂号时间
	*@param  time
	*/
	public void setTime(Date time ){
		this.time = time;
	}
	

}
