package com.gpj.entity;
import org.beetl.sql.core.annotatoin.Table;


/* 
* 
* gen by beetlsql 2021-03-08
*/
@Table(name="graduation.doctor")
public class Doctor   {
	
	// alias
	public static final String ALIAS_id = "id";
	public static final String ALIAS_age = "age";
	public static final String ALIAS_sex = "sex";
	public static final String ALIAS_user_id = "user_id";
	public static final String ALIAS_department = "department";
	public static final String ALIAS_name = "name";
	public static final String ALIAS_text = "text";
	public static final String ALIAS_price = "price";
	
	private Integer id ;
	/*
	年龄
	*/
	private Integer age ;
	/*
	性别
	*/
	private Integer sex ;
	/*
	登录账号
	*/
	private Integer userId ;
	/*
	部门
	*/
	private String department ;
	/*
	姓名
	*/
	private String name ;
	/*
	简介
	*/
	private String text ;

	private Integer price;

	
	public Doctor() {
	}
	
	public Integer getId(){
		return  id;
	}
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
	* 登录账号
	*@return 
	*/
	public Integer getUserId(){
		return  userId;
	}
	/**
	* 登录账号
	*@param  userId
	*/
	public void setUserId(Integer userId ){
		this.userId = userId;
	}
	
	/**
	* 部门
	*@return 
	*/
	public String getDepartment(){
		return  department;
	}
	/**
	* 部门
	*@param  department
	*/
	public void setDepartment(String department ){
		this.department = department;
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
	
	/**
	* 简介
	*@return 
	*/
	public String getText(){
		return  text;
	}
	/**
	* 简介
	*@param  text
	*/
	public void setText(String text ){
		this.text = text;
	}



	public void setPrice(Integer price ){
		this.price = price;
	}

	/**
	 * 年龄
	 *@return
	 */
	public Integer getPrice(){
		return  price;
	}
	

}
