package com.accolite.assignment;

public class EnqueueBook implements Runnable {
	
	private Integer[] ids;
	private Integer[] ISBN;
	private String[] title;
	private Boolean[] inCart;
	private Boolean[] isCheckedout;
	private Boolean[] underReview;
	private String[] reviewUser;
	private BlockingQueueBooks queue;

	public EnqueueBook(Integer[] ids, Integer[] iSBN, String[] title, Boolean[] inCart, Boolean[] isCheckedout, Boolean[] underReview,
			String[] reviewUser, BlockingQueueBooks queue) {
		super();
		this.ids = ids;
		ISBN = iSBN;
		this.title = title;
		this.inCart = inCart;
		this.isCheckedout = isCheckedout;
		this.underReview = underReview;
		this.reviewUser = reviewUser;
		this.queue = queue;
	}

	@Override
	public void run() {
		for(int i=0;i<ids.length;i++) {
			Book b = new Book(this.ids[i], this.ISBN[i],this.title[i], this.inCart[i], this.isCheckedout[i], this.underReview[i],this.reviewUser[i]);
			try {
				queue.put(b);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
