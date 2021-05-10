package com.mt.generatepassport;

import java.util.List;
import java.util.Scanner;

import com.mt.generatepassport.controller.PersonController;
import com.mt.generatepassport.entities.Passport;
import com.mt.generatepassport.entities.Person;
import com.mt.generatepassport.exceptions.ControllerException;
import com.mt.generatepassport.view.View;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("this is from master branch");
    	View.displayOptions();
    	byte choice = sc.nextByte();
    	
    	switch(choice) {
    		case 1:
    			Person person = View.createPerson();
    			Passport passport =  View.createPassport();
				try {
					PersonController.registerPerson(person, passport);
				} catch (ControllerException e) {
					System.out.println(e.getLocalizedMessage());
				}
				break;
    		case 2:
    			int id = View.inputId();
    			try {
    				Passport passportById = PersonController.getPassport(id);
    				System.out.println(passportById);
    			} catch (ControllerException e) {
					System.out.println(e.getLocalizedMessage());
				}
    			break;
    		case 3:
    			try {
    				List<Person> persons = PersonController.getSortedPersons();
    				View.printPersons(persons);
    			} catch (ControllerException e) {
					System.out.println(e.getLocalizedMessage());
				}
    			break;
    		default:
    			System.out.println("You have entered the wrong choice");
    			break;
    	}
    }
}
