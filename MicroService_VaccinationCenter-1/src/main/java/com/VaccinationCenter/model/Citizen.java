package com.VaccinationCenter.model;


public class Citizen {
	
	
	private int id;
	

	private String name;
	
	
	private int vacCentId;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getVacCentId() {
		return vacCentId;
	}


	public void setVacCentId(int vacCentId) {
		this.vacCentId = vacCentId;
	}


	public Citizen(int id, String name, int vacCentId) {
		super();
		this.id = id;
		this.name = name;
		this.vacCentId = vacCentId;
	}


	public Citizen() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Citizen [id=" + id + ", name=" + name + ", vacCentId=" + vacCentId + "]";
	}
	
	
}
