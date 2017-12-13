package com.httt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Department")
public class Department implements Serializable{
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    
    @Column(name = "dept_name", nullable = false)
    private String dept_name;
    
    @Column(name = "manager")
    private int magager;
    
    @Column(name = "numberofemployees")
    private int numberofemployees;
    
    @Column(name = "dept_infor")
    private String dept_infor;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(int id, String dept_name, int magager, int numberofemployees, String dept_infor) {
		super();
		this.id = id;
		this.dept_name = dept_name;
		this.magager = magager;
		this.numberofemployees = numberofemployees;
		this.dept_infor = dept_infor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public int getMagager() {
		return magager;
	}

	public void setMagager(int magager) {
		this.magager = magager;
	}

	public int getNumberofemployees() {
		return numberofemployees;
	}

	public void setNumberofemployees(int numberofemployees) {
		this.numberofemployees = numberofemployees;
	}

	public String getDept_infor() {
		return dept_infor;
	}

	public void setDept_infor(String dept_infor) {
		this.dept_infor = dept_infor;
	}
    
    

}
