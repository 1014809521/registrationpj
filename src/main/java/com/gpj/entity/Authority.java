package com.gpj.entity;
import org.beetl.sql.core.annotatoin.Table;


/* 
* 
* gen by beetlsql 2021-03-08
*/
@Table(name="graduation.authority")
public class Authority   {
	
	// alias
	public static final String ALIAS_id = "id";
	public static final String ALIAS_role = "role";
	public static final String ALIAS_password = "password";
	public static final String ALIAS_username = "username";
	
	/*
	主键
	*/
	private Integer id ;
	/*
	权限
	*/
	private Integer role ;
	/*
	密码
	*/
	private String password ;
	/*
	账号
	*/
	private String username ;
	
	public Authority() {
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
	* 权限
	*@return 
	*/
	public Integer getRole(){
		return  role;
	}
	/**
	* 权限
	*@param  role
	*/
	public void setRole(Integer role ){
		this.role = role;
	}
	
	/**
	* 密码
	*@return 
	*/
	public String getPassword(){
		return  password;
	}
	/**
	* 密码
	*@param  password
	*/
	public void setPassword(String password ){
		this.password = password;
	}
	
	/**
	* 账号
	*@return 
	*/
	public String getUsername(){
		return  username;
	}
	/**
	* 账号
	*@param  username
	*/
	public void setUsername(String username ){
		this.username = username;
	}
	

}
