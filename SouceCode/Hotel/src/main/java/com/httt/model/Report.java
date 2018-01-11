package com.httt.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Report")
public class Report implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "type", nullable = false)
	private String type;

	@Column(name = "created_person", nullable = false)
	private int created_person;

	@Column(name = "created_at", nullable = false)
	private Date created_at;

	@Column(name = "content")
	private String content;

	@Column(name = "note")
	private String note;
	
	@Column(name = "file")
	private String file;

	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Report(int id, String name, String type, int created_person, Date created_at, String content, String note, String file) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.created_person = created_person;
		this.created_at = created_at;
		this.content = content;
		this.note = note;
		this.file = file;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCreated_person() {
		return created_person;
	}

	public void setCreated_person(int created_person) {
		this.created_person = created_person;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
	
	
}
