package com.VaccinationCenter.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VaccinationCenter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	
	public String centerName;
	public String centerAdd;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getCenterAdd() {
		return centerAdd;
	}
	public void setCenterAdd(String centerAdd) {
		this.centerAdd = centerAdd;
	}
	public VaccinationCenter(int id, String centerName, String centerAdd) {
		super();
		this.id = id;
		this.centerName = centerName;
		this.centerAdd = centerAdd;
	}
	public VaccinationCenter() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "VaccinationCenter [id=" + id + ", centerName=" + centerName + ", centerAdd=" + centerAdd + "]";
	}
	
	
}
