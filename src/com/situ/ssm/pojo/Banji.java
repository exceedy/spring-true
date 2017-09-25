package com.situ.ssm.pojo;

import java.util.List;

public class Banji {
	private Integer id;
	private String name;
	List<Coures> couresList;
	
	
	
	
	public Banji() {
		super();
	}
	
	
	public Banji(Integer id, String name, List<Coures> couresList) {
		super();
		this.id = id;
		this.name = name;
		this.couresList = couresList;
	}
	

	public Banji(String name) {
		super();
		this.name = name;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Coures> getCouresList() {
		return couresList;
	}
	public void setCouresList(List<Coures> couresList) {
		this.couresList = couresList;
	}
	@Override
	public String toString() {
		return "Banji [id=" + id + ", name=" + name + ", couresList=" + couresList + "]";
	}
	
	
	
}
