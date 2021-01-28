package com.accolite.assignment;

import java.util.ArrayList;

public class Review implements Runnable{
	
	private BlockingQueueBooks queue;
	private Student student;
	private ArrayList<Book> books;
	private Book book;
	

	public Review(BlockingQueueBooks queue, Student student, ArrayList<Book> books, Book book) {
		super();
		this.queue = queue;
		this.student = student;
		this.books = books;
		this.book = book;
	}

	@Override
	public void run() {
		try {
			queue.review(student,book);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(books.size() > 0) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for(Book b: books) {
				try {
					if(b.getId()== book.getId())
						queue.removeFromCart(student,book);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}		
			}
		}
	}
}
