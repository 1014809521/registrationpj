package com.gpj.entity;
import org.beetl.sql.core.annotatoin.Table;


/* 
* 
* gen by beetlsql 2021-03-08
*/
@Table(name="graduation.department")
public class Department   {
	
	// alias
	public static final String ALIAS_id = "id";
	public static final String ALIAS_name = "name";
	public static final String ALIAS_type = "type";
	
	private Integer id ;
	private String name ;
	private String type ;
	
	public Department() {
	}
	
	public Integer getId(){
		return  id;
	}
	public void setId(Integer id ){
		this.id = id;
	}
	
	public String getName(){
		return  name;
	}
	public void setName(String name ){
		this.name = name;
	}
	
	public String getType(){
		return  type;
	}
	public void setType(String type ){
		this.type = type;
	}
	

}
