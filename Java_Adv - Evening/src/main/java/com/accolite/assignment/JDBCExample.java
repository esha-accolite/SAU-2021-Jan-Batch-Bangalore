package com.accolite.assignment;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ThreadLocalRandom;

public class JDBCExample {
	
	@MyAnnotation
	public static int getRandomValue(int Min, int Max) 
    { 
        return ThreadLocalRandom.current().nextInt(Min, Max + 1); 
    }
	
	public static void writeInFile() throws IOException {
		FileWriter out;
		out = new FileWriter("numInput.txt");
		while(true) {
			Integer val = getRandomValue(1, 100);
//		    System.out.println(val);
			if(val%5==0)
			{
				out.write(val.toString());
				break;
			}
			out.write(val.toString()+" ");
		}
		out.close();
	}
	
	public static Integer readFromFile() throws IOException {
		FileReader in;
		in = new FileReader("numInput.txt");
		int c;
		String num="";
		while((c = in.read()) != -1) {
//			System.out.println((char)c);
			if((char)c==' ') {
				num="";
			}
			else {
				num = num+(char)c;
			}
		}
//		System.out.println(num);
		num = num.replaceAll("[^\\d.]", "");
		Integer ans = Integer.parseInt(num);
		ans = ans*2;
		System.out.println(ans);
		in.close();
		return ans;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://remotemysql.com:3306/sMkXvyYxZM";
		String username = "sMkXvyYxZM";
		String password = "8h9tWhCKws";
		
		Connection connection = DriverManager.getConnection(url,username,password);
		
		Statement statement = connection.createStatement();
		
		writeInFile();
		
		Integer ans = readFromFile();
		
//		String sql = "CREATE TABLE numbers(id INTEGER UNIQUE, name VARCHAR(50),PRIMARY KEY(id))";
		String sql = "INSERT INTO test(id, name) VALUES("+ans+",\"esha\")";
//		String sql = "SELECT * FROM numbers";
//		ResultSet result = statement.executeQuery(sql);
		Integer result = statement.executeUpdate(sql);
//		while(result.next())
//		{
//			Integer id = result.getInt("id");
//			String name = result.getString("name");
//		}
	}

}
