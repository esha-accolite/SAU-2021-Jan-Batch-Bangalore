package com.accolite.assignment;

import java.util.ArrayList;

public class Library {
	
	private static ArrayList<Book> books;
	private static ArrayList<Student> students;

	public static ArrayList<Book> getBooks() {
		return books;
	}
	public static void setBooks(ArrayList<Book> books) {
		Library.books = books;
	}
	public static ArrayList<Student> getStudents() {
		return students;
	}
	public static void setStudents(ArrayList<Student> students) {
		Library.students = students;
	}


	private static void addinitialBooks(BlockingQueueBooks queue) {
		
		Integer[] id = { 1,2,3,4,5,6,7,8,9,10 };
		Integer[] ISBN = {11,22,33,44,55,66,77,88,99,1010};
		String[] title = {"Book1","Book2","Book3","Book4","Book5","Book6","Book7","Book8","Book9","Book10"};
		Boolean[] inCart = {false,false,false,false,false,false,false,false,false,false};
		Boolean[] isCheckedout = {false,false,false,false,false,false,false,false,false,false};		
		Boolean[] underReview = {false,false,false,false,false,false,false,false,false,false}; 
		String[] reviewUser = {"","","","","","","","","",""};
		
		Thread initializeBooks = new Thread(new EnqueueBook(id,ISBN,title,inCart,isCheckedout,underReview,reviewUser,queue));
		initializeBooks.start();
		
		for(int i=0;i<10;i++) {
			Book b = new Book(id[i], ISBN[i],title[i], inCart[i],isCheckedout[i], underReview[i],reviewUser[i]);
			books.add(b);
		}
	}
	
	public static void addinitialStudents() {
		
		Integer[] id = { 1,2,3,4,5,6,7,8,9,10 };
		String[] name = {"Stud1","Stud2","Stud3","Stud4","Stud5","Stud6","Stud7","Stud8","Stud9","Stud10"};
	
		for(int i=0;i<10;i++) {
			Student student = new Student(id[i], name[i]);
			students.add(student);
		}
	}
	
	public static void getStudentDetails() {
		for(Student s : students) {
			s.getdetails();
		}
	}
	
	public static void getBooksDetails() {
		for(Book b : books) {
			b.getdetails();
		}
	}
	
	public static void main(String[] args) {
		addinitialStudents();
		BlockingQueueBooks queue = new BlockingQueueBooks();
		addinitialBooks(queue);
		
		getStudentDetails();
		getBooksDetails();
		
		Thread t1 = new Thread(new Review(queue,students.get(2),books,books.get(1)));
		t1.start();
		
		Thread t2 = new Thread(new Review(queue,students.get(6),books,books.get(9)));
		t2.start();
		
		Thread t3 = new Thread(new Review(queue,students.get(7),books,books.get(1)));
		t3.start();
		
		Thread t4 = new Thread(new CartAdd(students.get(2),queue,books.get(1)));
		t4.start();
		
		Thread t5 = new Thread(new CartRemove(students.get(2),queue,books.get(1)));
		t5.start();
		
		Thread t6 = new Thread(new Order(queue,students.get(6),books.get(9)));
		t6.start();
	
	}

}
