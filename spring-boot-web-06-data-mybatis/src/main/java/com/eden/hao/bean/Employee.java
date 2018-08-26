package com.eden.hao.bean;

public class Employee {

	private Integer id;
	
	private String lastName;
	
	private Integer gender;
	
	private String eamil;
	
	private Integer dId;

	public Integer getId() {
		return id;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getEamil() {
		return eamil;
	}

	public void setEamil(String eamil) {
		this.eamil = eamil;
	}

	public Integer getdId() {
		return dId;
	}

	public void setdId(Integer dId) {
		this.dId = dId;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", gender=" + gender + ", eamil=" + eamil + ", dId="
				+ dId + "]";
	}
	
	 
}
