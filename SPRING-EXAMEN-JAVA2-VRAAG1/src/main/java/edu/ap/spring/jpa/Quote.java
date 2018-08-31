package edu.ap.spring.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Quote {
	
	   @Id
	   @GeneratedValue
	   private Long id;
	   
	   private String text;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Quote(String text) {
		super();
		this.text = text;
	}

	@Override
	public String toString() {
		return "Quote [id=" + id + ", text=" + text + "]";
	}
	   
	   
}
