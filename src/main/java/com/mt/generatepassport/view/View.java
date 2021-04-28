package com.mt.generatepassport.view;

import java.util.List;
import java.util.Scanner;

import com.mt.generatepassport.entities.Passport;
import com.mt.generatepassport.entities.Person;

public class View {

	private static Scanner sc = new Scanner(System.in);
	public static Person createPerson() {
		
		System.out.println("Enter the id of the person");
		int id = sc.nextInt();
		System.out.println("Enter the name of the person");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.println("Enter the age of the person");
		int age = sc.nextInt();
		System.out.println("Enter the gender of the person");
		String gender = sc.next();
		
		return new Person(id, name, age, gender);
	}
	
	public static Passport createPassport() {
		
		System.out.println("Enter the id of the passport");
		int id = sc.nextInt();
		System.out.println("Enter the passport number");
		int passportNo = sc.nextInt();
		System.out.println("Enter the place where the passport has been issued");
		sc.nextLine();
		String place = sc.nextLine();
		System.out.println("Enter the date of issuing");
		String date = sc.nextLine();
		
		return new Passport(id, passportNo, place, date);
	}

	public static void displayOptions() {
		System.out.println("Enter 1 to create a person with his passport");
		System.out.println("Enter 2 to get the passport details of a person by his id");
		System.out.println("Enter 3 to sort all the persons on the basis of their age and if age is same then sort them on the basis of their name");
	}

	public static void printPersons(List<Person> persons) {
		for(Person person: persons) {
			System.out.println(person);
		}
	}

	public static int inputId() {
		System.out.println("Enter the id of the person whose passport details has to be fetched");
		return sc.nextInt();
	}
}
