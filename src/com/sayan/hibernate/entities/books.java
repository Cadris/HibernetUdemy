package com.sayan.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="books")
@Table(name="books")
public class books {
	
	@Id
	@Column(name="id")
	int id;
	
	@Column(name="title")
	String title;
	
	@Column(name="publishyear")
	int publishyear;
	
	@Column(name="pages")
	int pages;
	
	public books() {}

	public books(String title, int publishyear, int pages) {
		this.title = title;
		this.publishyear = publishyear;
		this.pages = pages;
	}

	@Override
	public String toString() {
		return "book [title=" + title + ", publishyear=" + publishyear + ", pages=" + pages + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPublishyear() {
		return publishyear;
	}

	public void setPublishyear(int publishyear) {
		this.publishyear = publishyear;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}
}
