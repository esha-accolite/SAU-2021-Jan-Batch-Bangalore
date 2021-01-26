package com.accolite.hibernate1.assign;

public class Library {
	
	private int id;
	
	private String title;
	
	private String subtitle;
	
	private String author;
	
	private String publisher;
	
	private int pages;
	
	public Library() {
		
	}

	public Library(String title, String subtitle, String author, String publisher, int pages) {
		super();
		this.title = title;
		this.subtitle = subtitle;
		this.author = author;
		this.publisher = publisher;
		this.pages = pages;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	
}
