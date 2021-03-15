package com.gpj.entity;
import org.beetl.sql.core.annotatoin.Table;


/* 
* 
* gen by beetlsql 2021-03-08
*/
@Table(name="graduation.patient")
public class Patient   {
	
	// alias
	public static final String ALIAS_id = "id";
	public static final String ALIAS_age = "age";
	public static final String ALIAS_registration_id = "registration_id";
	public static final String ALIAS_sex = "sex";
	public static final String ALIAS_user_id = "user_id";
	public static final String ALIAS_name = "name";
	
	/*
	主键
	*/
	private Integer id ;
	/*
	年龄
	*/
	private Integer age ;
	/*
	挂号信息
	*/
	private Integer registrationId ;
	/*
	性别
	*/
	private Integer sex ;
	/*
	登录
	*/
	private Integer userId ;
	/*
	姓名
	*/
	private String name ;
	
	public Patient() {
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
	* 年龄
	*@return 
	*/
	public Integer getAge(){
		return  age;
	}
	/**
	* 年龄
	*@param  age
	*/
	public void setAge(Integer age ){
		this.age = age;
	}
	
	/**
	* 挂号信息
	*@return 
	*/
	public Integer getRegistrationId(){
		return  registrationId;
	}
	/**
	* 挂号信息
	*@param  registrationId
	*/
	public void setRegistrationId(Integer registrationId ){
		this.registrationId = registrationId;
	}
	
	/**
	* 性别
	*@return 
	*/
	public Integer getSex(){
		return  sex;
	}
	/**
	* 性别
	*@param  sex
	*/
	public void setSex(Integer sex ){
		this.sex = sex;
	}
	
	/**
	* 登录
	*@return 
	*/
	public Integer getUserId(){
		return  userId;
	}
	/**
	* 登录
	*@param  userId
	*/
	public void setUserId(Integer userId ){
		this.userId = userId;
	}
	
	/**
	* 姓名
	*@return 
	*/
	public String getName(){
		return  name;
	}
	/**
	* 姓名
	*@param  name
	*/
	public void setName(String name ){
		this.name = name;
	}
	

}
