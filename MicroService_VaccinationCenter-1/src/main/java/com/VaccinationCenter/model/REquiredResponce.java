package com.VaccinationCenter.model;

import java.util.List;

import com.VaccinationCenter.entity.VaccinationCenter;

public class REquiredResponce {
	
	private VaccinationCenter center;
	private List<Citizen> citizens;
	public VaccinationCenter getCenter() {
		return center;
	}
	public void setCenter(VaccinationCenter center) {
		this.center = center;
	}
	public List<Citizen> getCitizens() {
		return citizens;
	}
	public void setCitizens(List<Citizen> citizens) {
		this.citizens = citizens;
	}
	public REquiredResponce(VaccinationCenter center, List<Citizen> citizens) {
		super();
		this.center = center;
		this.citizens = citizens;
	}
	public REquiredResponce() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	
}
