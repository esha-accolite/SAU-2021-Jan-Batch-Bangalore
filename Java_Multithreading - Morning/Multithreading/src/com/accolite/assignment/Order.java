package com.accolite.assignment;

public class Order implements Runnable{

	private BlockingQueueBooks queue;
	private Student student;
	private Book book;
	
	
	public Order(BlockingQueueBooks queue, Student student, Book book) {
		super();
		this.queue = queue;
		this.student = student;
		this.book = book;
	}

	@Override
	public void run() {
		try {
			queue.checkout(student,book);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
