package com.mt.generatepassport.service;

import java.util.List;

import com.mt.generatepassport.entities.Passport;
import com.mt.generatepassport.entities.Person;
import com.mt.generatepassport.exceptions.ServiceException;

public interface PersonService {

	void registerPerson(Person person, Passport passport) throws ServiceException;

	Passport getPassport(int id) throws ServiceException;

	List<Person> getSortedPerson() throws ServiceException;

}
