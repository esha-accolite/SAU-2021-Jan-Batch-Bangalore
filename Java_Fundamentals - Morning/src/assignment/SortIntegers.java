package assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SortIntegers {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>(); 
		
		System.out.println("Enter integers and stop with '.'");
		Scanner in = new Scanner(System.in);
		String num="";
		while(true) {
			num = in.nextLine();
			if(num.equals("."))
				break;
			list.add(Integer.parseInt(num));
		}
 
        Collections.sort(list); 
  
        System.out.println("Sorted :\n" + list); 
	}

}
