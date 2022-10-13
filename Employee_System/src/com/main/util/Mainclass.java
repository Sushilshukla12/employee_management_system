package com.main.util;

import java.util.List;
import java.util.Scanner;

import com.Dao.util.Dao;
import com.Getset.util.Getset;

public class Mainclass {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true) {
	
		System.out.println("1.Create New List");
		System.out.println("2.Update List");
		System.out.println("3.Delete List");
		System.out.println("4.Search By ID");
		System.out.println("5.Show All List");
		
		
		System.out.println("Enter Your Choice");
		int Choice=sc.nextInt();
		int id;
		String first_name;
		String last_name;
		int age;
	
		switch(Choice){
		
		case 1:System.out.println("Enter employee id : ");
		id=sc.nextInt();
		System.out.println("Enter First name : ");
		first_name=sc.next();
		System.out.println("Enter Last name : ");
		last_name=sc.next();
		System.out.println("Enter Age");
		age=sc.nextInt();
		
		
		boolean res=Dao.insertRecord(id,first_name,last_name,age);
		if(res)
			System.out.println("Created List Successfully");
		else
			System.out.println("Not created");
		break;
		case 2:System.out.println("Enter id");
		id=sc.nextInt();
		Getset get=Dao.searchById(id);
		System.out.println("What do you want to update?");
 		System.out.println("1. Employee First name");
 		System.out.println("2. Employee Last name");
 		System.out.println("3. Employee Age");
 		int update =sc.nextInt();
 		switch(update) {
 		case 1: System.out.println("Enter New First Name:");
 		first_name = sc.next();
 		get.setFirst_name(first_name);				 		 	
 		break;
 		case 2: System.out.println("Enter New Last Name:");
		last_name = sc.next();
		get.setLast_name(last_name);
		break;
 		
 		case 3: System.out.println("Enter New Age:");
		age = sc.nextInt();
		get.setAge(age);	
		break;
 		}
 		res=Dao.updateRecord(get);
 		if(res)
 			System.out.println("updated successfuly");
 		else
 			System.out.println("not updated");
 		break;
 		
		case 3:
		System.out.print("Enter the ID of the product:");
 		 id = sc.nextInt();	
 		 res =Dao.deleteRecord(id);
		if(res)
			System.out.println("Deleted Successfully");
		else
			System.out.println("Not Deleted");
	break;
		
		
		
		
		case 4:
		System.out.print("Enter the ID of the employee:");
		 id = sc.nextInt();
		 get = Dao.searchById(id);
		 if(get.getId() != 0)
			 System.out.println(get);
		 break;
		 
		 
		 
		 
		case 5:List<Getset> p= Dao.getAllRecords();
  		
  		for(Getset s:p) {
  			System.out.println(s);
  		}
  		
  		break;

	}
		}
	}
}
