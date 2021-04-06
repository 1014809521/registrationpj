package com.gpj.entity;
import org.beetl.sql.core.annotatoin.Table;


/* 
* 
* gen by beetlsql 2021-03-08
*/
@Table(name="graduation.return")
public class Return   {
	
	// alias
	public static final String ALIAS_id = "id";
	public static final String ALIAS_doctor_id = "doctor_id";
	public static final String ALIAS_patient_id = "patient_id";
	public static final String ALIAS_registration_id = "registration_id";
	public static final String ALIAS_describe = "describe";
	public static final String ALIAS_question = "question";
	
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
	挂号id
	*/
	private Integer registrationId ;
	private String describe ;
	/*
	就诊状态
	*/
	private String question ;
	
	public Return() {
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
	* 挂号id
	*@return 
	*/
	public Integer getRegistrationId(){
		return  registrationId;
	}
	/**
	* 挂号id
	*@param  registrationId
	*/
	public void setRegistrationId(Integer registrationId ){
		this.registrationId = registrationId;
	}
	
	public String getDescribe(){
		return  describe;
	}
	public void setDescribe(String describe ){
		this.describe = describe;
	}
	
	/**
	* 就诊状态
	*@return 
	*/
	public String getQuestion(){
		return  question;
	}
	/**
	* 就诊状态
	*@param  question
	*/
	public void setQuestion(String question ){
		this.question = question;
	}
	

}
