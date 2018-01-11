package com.httt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Department")
public class Department implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "manager", nullable = false)
    private int manager;
    
    @Column(name = "numberofemployees")
    private int numberofemployees;
    
    @Column(name = "dept_infor")
    private String dept_infor;

	public Department(int id, String name, int manager, int numberofemployees, String dept_infor) {
		super();
		this.id = id;
		this.name = name;
		this.manager = manager;
		this.numberofemployees = numberofemployees;
		this.dept_infor = dept_infor;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public int getManager() {
		return manager;
	}

	public void setManager(int manager) {
		this.manager = manager;
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
