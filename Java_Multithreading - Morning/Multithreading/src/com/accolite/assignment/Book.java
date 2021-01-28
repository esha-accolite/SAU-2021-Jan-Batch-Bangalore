package com.accolite.assignment;

public class Book {
	
	private Integer id;
	private Integer ISBN;
	private String title;
//	private String author;
	private Boolean inCart;
	private Boolean isCheckedout;
	private Boolean underReview;
	private String reviewUser;
	
	public Book(Integer id,Integer iSBN, String title, Boolean inCart, Boolean isCheckedout, Boolean underReview,
			String reviewUser) {
		super();
		this.id = id;
		this.ISBN = iSBN;
		this.title = title;
//		this.author = author;
		this.inCart = inCart;
		this.isCheckedout = isCheckedout;
		this.underReview = underReview;
		this.reviewUser = reviewUser;
	}
	
	

	public Boolean getInCart() {
		return inCart;
	}

	public void setInCart(Boolean inCart) {
		this.inCart = inCart;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getISBN() {
		return ISBN;
	}
	public void setISBN(Integer iSBN) {
		ISBN = iSBN;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
//	public String getAuthor() {
//		return author;
//	}
//	public void setAuthor(String author) {
//		this.author = author;
//	}
	public Boolean getIsCheckedout() {
		return isCheckedout;
	}
	public void setIsCheckedout(Boolean isCheckedout) {
		this.isCheckedout = isCheckedout;
	}
	public Boolean getUnderReview() {
		return underReview;
	}
	public void setUnderReview(Boolean underReview) {
		this.underReview = underReview;
	}
	public String getReviewUser() {
		return reviewUser;
	}
	public void setReviewUser(String reviewUser) {
		this.reviewUser = reviewUser;
	}
	
	public void getdetails() {
		System.out.println("Book details - ");
		System.out.println("Id : "+this.id);
		System.out.println("ISBN : "+this.ISBN);
		System.out.println("title : "+this.title);
//		System.out.println("author : "+this.author);
		System.out.println("inCart : "+this.inCart);
		System.out.println("isCheckedout : "+this.isCheckedout);
		System.out.println("underReview : "+this.underReview);
		System.out.println("reviewUser : "+this.reviewUser);
	}
}
