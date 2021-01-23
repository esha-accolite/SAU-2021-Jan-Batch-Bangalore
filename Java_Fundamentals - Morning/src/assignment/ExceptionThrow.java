package assignment;

import java.util.Scanner;

public class ExceptionThrow {
	
	public static void checkPos(int num){ 
		if(num<0) {
			throw new ArithmeticException("Negative number!! Please enter positive number only!"); 
		}
	    else {
	        System.out.println(num); 
	    }
	}

	public static void main(String args[]){ 
	     System.out.println("Enter positive numbers!!");
	     Scanner in = new Scanner(System.in); 
	     Integer num = in.nextInt();
	     checkPos(num); 
	} 

}
