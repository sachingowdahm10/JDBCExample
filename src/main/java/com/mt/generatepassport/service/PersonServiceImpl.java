package com.mt.generatepassport.service;

import java.util.Collections;
import java.util.List;

import com.mt.generatepassport.entities.Passport;
import com.mt.generatepassport.entities.Person;
import com.mt.generatepassport.exceptions.RepositoryException;
import com.mt.generatepassport.exceptions.ServiceException;
import com.mt.generatepassport.repository.PersonRepository;
import com.mt.generatepassport.repository.PersonRepositoryImpl;

public class PersonServiceImpl implements PersonService {

	private static PersonRepository personRepository = new PersonRepositoryImpl();
	
	public  void registerPerson(Person person, Passport passport) throws ServiceException {
		try {
			personRepository.registerPerson(person, passport);
		} catch(RepositoryException e) {
			throw new ServiceException(e.getLocalizedMessage(), e);
		}
	}

	public  Passport getPassport(int id) throws ServiceException {
		int passport_id = 0;
		Passport passport = null;
		try {
			passport_id = personRepository.getPassportId(id);
			passport = personRepository.getPassport(passport_id);
			
		} catch(RepositoryException e) {
			throw new ServiceException(e.getLocalizedMessage(), e);
		}
		return passport;
	}

	public  List<Person> getSortedPerson() throws ServiceException {
		List<Person> persons = null;
		try {
			persons =  personRepository.getPersons();
		} catch(RepositoryException e) {
			throw new ServiceException(e.getLocalizedMessage(), e);
		}
		
		Collections.sort(persons, (person1, person2)->{
			if(person1.getAge()==person2.getAge()) {
				return person1.getName().compareTo(person2.getName());
			}
			return person1.getAge()-person2.getAge();
		});
		
		return persons;
	}

}
