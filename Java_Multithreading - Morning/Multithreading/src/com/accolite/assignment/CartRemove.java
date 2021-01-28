package com.accolite.assignment;

public class CartRemove implements Runnable{

	private Student student;
	private BlockingQueueBooks queue;
	private Book book;

	public CartRemove(Student student, BlockingQueueBooks queue, Book book) {
		super();
		this.student = student;
		this.queue = queue;
		this.book = book;
	}

	@Override
	public void run() {
				try {
					queue.removeFromCart(student, book);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
	}
}
