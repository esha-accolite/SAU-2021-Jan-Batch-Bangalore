package com.accolite.assignment;

import java.util.ArrayList;

public class Student {

	private Integer id;
	private String name;
	private ArrayList<Book> booksUnderReview;
	private ArrayList<Book> booksInCart;
	private ArrayList<Book> booksCheckedout;
	
	public Student() {}
	
	public Student(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.booksUnderReview = new ArrayList<Book>();
		this.booksInCart = new ArrayList<Book>();
		this.booksCheckedout = new ArrayList<Book>();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Book> getBooksUnderReview() {
		return booksUnderReview;
	}
	public void setBooksUnderReview(ArrayList<Book> booksUnderReview) {
		this.booksUnderReview = booksUnderReview;
	}
	
	public ArrayList<Book> getBooksInCart() {
		return booksInCart;
	}
	public void setBooksInCart(ArrayList<Book> booksInCart) {
		this.booksInCart = booksInCart;
	}
	public ArrayList<Book> getBooksCheckedout() {
		return booksCheckedout;
	}
	public void setBooksCheckedout(ArrayList<Book> booksCheckedout) {
		this.booksCheckedout = booksCheckedout;
	}
	
	public void addUnderReview(Book book) {
		this.booksUnderReview.add(book);
	}
	
	public void removeUnderReview(Book book) {
		this.booksUnderReview.remove(book);
	}
	
	public void addBooksInCart(Book book) {
		this.booksInCart.add(book);
	}
	
	public void removeBooksInCart(Book book) {
		this.booksInCart.remove(book);
	}
	
	public void addBooksCheckedout(Book book) {
		this.booksCheckedout.add(book);
	}
	
	public void getdetails() {
		System.out.println("Student details - ");
		System.out.println("Id : "+this.id);
		System.out.println("name : "+this.name);
		System.out.println("Books Under Review - ");
		for(Book bookItem : booksUnderReview) {
			bookItem.getdetails();
		}
		System.out.println("Books In Cart - ");
		for(Book bookItem : booksInCart) {
			bookItem.getdetails();
		}
		System.out.println("Books Checkedout - ");
		for(Book bookItem : booksCheckedout) {
			bookItem.getdetails();
		}
	}
	
	public boolean canReview(Integer id) {
		for(Book b : booksInCart) {
			if(b.getId() == id)
				return true;
		}
		return false;
	}
	
	public boolean canAddInCart(Integer id) {
		for(Book b : booksUnderReview) {
			if(b.getId() == id)
				return true;
		}
		return false;
	}
	
	public boolean canRemoveFromCart(Integer id) {
		for(Book b : booksInCart) {
			if(b.getId() == id)
				return true;
		}
		return false;
	}
	
	public boolean canBuy(Integer id) {
		for(Book b : booksInCart) {
			if(b.getId() == id)
				return true;
		}
		return false;
	}
	
	
	
}
