package app04b.domain;

import java.io.Serializable;
import java.util.*;

public class Product implements Serializable{
	private static final long serialVersionUID = 748392348L;
	private String name;
	private String description;
	private float price;
	
	private long id;
	
	public void setId(long id){
		this.id = id;
	}
	
	public long getId(){
		return this.id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public float getPrice(){
		return price;
	}
	
	public void setPrice(float price){
		this.price = price;
	}
	
}