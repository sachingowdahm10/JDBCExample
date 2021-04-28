package com.mt.generatepassport.controller;

import java.util.List;

import com.mt.generatepassport.entities.Passport;
import com.mt.generatepassport.entities.Person;
import com.mt.generatepassport.exceptions.ControllerException;
import com.mt.generatepassport.exceptions.ServiceException;
import com.mt.generatepassport.service.PersonService;
import com.mt.generatepassport.service.PersonServiceImpl;

public class PersonController {

	private static PersonService personService = new PersonServiceImpl();
	
	public static void registerPerson(Person person, Passport passport) throws ControllerException {
		
		try {
			personService.registerPerson(person, passport);
		}catch(ServiceException e) {
			throw new ControllerException(e.getLocalizedMessage(), e);
		}
	}

	public static Passport getPassport(int id) throws ControllerException {
		Passport passport= null;
		try {
			passport = personService.getPassport(id);
		} catch (ServiceException e) {
			throw new ControllerException(e.getLocalizedMessage(), e);
		}
		return passport;
	}

	public static List<Person> getSortedPersons() throws ControllerException {
		List<Person> persons = null;
		try {
			persons = personService.getSortedPerson();
		} catch(ServiceException e) {
			throw new ControllerException(e.getLocalizedMessage(), e);
		}
		return persons;
	}

}
