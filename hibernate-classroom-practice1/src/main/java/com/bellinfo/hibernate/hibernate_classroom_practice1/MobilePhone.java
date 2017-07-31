package com.bellinfo.hibernate.hibernate_classroom_practice1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class MobilePhone {

	private String brand;
	private String model;
	private double cost;
	private int memory;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int mobileid;
	
	public MobilePhone(){
		
	}
	
	public MobilePhone(String brand, String model, double cost, int memory) {
		super();
		this.brand = brand;
		this.model = model;
		this.cost = cost;
		this.memory = memory;
	}

	
	public int getMobileid() {
		return mobileid;
	}

	public void setMobileid(int mobileid) {
		this.mobileid = mobileid;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	@Override
	public String toString() {
		return "MobilePhone [brand=" + brand + ", model=" + model + ", cost="
				+ cost + ", memory=" + memory + ", mobileid=" + mobileid + "]";
	}
	
	
	
}
