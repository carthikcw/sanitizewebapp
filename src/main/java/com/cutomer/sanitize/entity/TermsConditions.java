package com.cutomer.sanitize.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "termsconditions_tab")
public class TermsConditions {
	@Id
	@Column(name = "terms_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String category;
	private String content;
	
	
	public TermsConditions() {
		super();
	}


	public TermsConditions(int id, String category, String content) {
		super();
		this.id = id;
		this.category = category;
		this.content = content;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	@Override
	public String toString() {
		return "TermsConditions [id=" + id + ", category=" + category + ", content=" + content + "]";
	}
	
	

	

}
