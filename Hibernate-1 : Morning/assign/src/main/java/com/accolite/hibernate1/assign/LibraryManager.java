package com.accolite.hibernate1.assign;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

public class LibraryManager {
	
	@Autowired
	private static SessionFactory factory;
	
	public static void main(String[] args) {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
		
		LibraryManager libraryManager = new LibraryManager();
//		Integer bookId = libraryManager.addBook("You Don't Know JS","ES6 & Beyond","Kyle Simpson","O'Reilly Media",278);
//		Integer bookId = libraryManager.addBook("Git Pocket Guide","A Working Introduction","Richard E. Silverman","O'Reilly Media",234);
//		Integer bookId = libraryManager.addBook("Speaking JavaScript","An In-Depth Guide for Programmers","Axel Rauschmayer","O'Reilly Media",460);
//		Integer bookId = libraryManager.addBook("Learning JavaScript Design Patterns","A JavaScript and jQuery Developer's Guide","Addy Osmani","O'Reilly Media",254);
//		Integer bookId = libraryManager.addBook("Understanding ECMAScript 6","The Definitive Guide for JavaScript Developers","Nicholas C. Zakas","No Starch Press",352);
//		System.out.println("Book is inserted :"+ bookId.intValue());
//		libraryManager.getBooks();
//		libraryManager.updateBook(3);
//		libraryManager.deleteBook(4);
		Integer numOfBooks = libraryManager.countOfBooks();
		System.out.println("Count of Books : "+numOfBooks);
	}
	
	private Integer addBook(String title, String subtitle, String author, String publisher, Integer pages)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		Integer bookId = null;
		try {
			tx = session.beginTransaction();
			Library book = new Library(title, subtitle, author, publisher, pages);
			bookId = (Integer) session.save(book);
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
		}finally {
			System.out.println("Book added: ");
			System.out.println("title : "+title+"\nsubtitle : "+subtitle+"\nauthor : "+author+"\npublisher : "+publisher+"\npages : "+pages);
			session.close();
		}
		return bookId;
	}
	
	private void getBooks()
	{
		Session session = factory.openSession();
		Transaction tx = null;
		Integer numOfBooks = 0;
		try {
			tx = session.beginTransaction();
			List<Library> books = session.createQuery("FROM Library").list();
			numOfBooks = books.size();
			if(numOfBooks==0) {
				System.out.println("Books not available");
			}
			else {
				for(Library book : books) {
					System.out.println("Id : "+book.getId()+"\ntitle : "+book.getTitle()+"\nsubtitle : "+book.getSubtitle()+"\nauthor : "+book.getAuthor()+"\npublisher : "+book.getPublisher()+"\npages : "+book.getPages());
				}
			}
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
		}finally {
			session.close();
		}
	}
	
	private void updateBook(Integer id)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		Integer bookId = id;
		try {
			tx = session.beginTransaction();
			Library book = session.get(Library.class, bookId);
			System.out.println("Selected book: ");
			System.out.println("Id : "+book.getId()+"\ntitle : "+book.getTitle()+"\nsubtitle : "+book.getSubtitle()+"\nauthor : "+book.getAuthor()+"\npublisher : "+book.getPublisher()+"\npages : "+book.getPages());
			book.setTitle("New Title");
			book.setPublisher("New Publisher");
			session.update(book);
			System.out.println("Updated book: ");
			System.out.println("Id : "+book.getId()+"\ntitle : "+book.getTitle()+"\nsubtitle : "+book.getSubtitle()+"\nauthor : "+book.getAuthor()+"\npublisher : "+book.getPublisher()+"\npages : "+book.getPages());
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
		}finally {
			session.close();
		}
	}
	
	private void deleteBook(int id)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		int bookId = id;
		try {
			tx = session.beginTransaction();
			Library book = session.get(Library.class, bookId);
			System.out.println("Selected book: ");
			System.out.println("Id : "+book.getId()+"\ntitle : "+book.getTitle()+"\nsubtitle : "+book.getSubtitle()+"\nauthor : "+book.getAuthor()+"\npublisher : "+book.getPublisher()+"\npages : "+book.getPages());
			session.delete(book);
			System.out.println("Book : "+bookId+" deleted successfully");
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
		}finally {
			
			session.close();
		}
	}
	
	private Integer countOfBooks()
	{
		Session session = factory.openSession();
		Transaction tx = null;
		Integer numOfBooks = 0;
		try {
			tx = session.beginTransaction();
			List<Library> books = session.createQuery("FROM Library").list();
			numOfBooks = books.size();
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
		}finally {
			session.close();
		}
		return numOfBooks;
	}
	

}
