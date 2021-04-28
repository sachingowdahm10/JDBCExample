package com.mt.generatepassport.repository;

import java.util.List;

import com.mt.generatepassport.entities.Passport;
import com.mt.generatepassport.entities.Person;
import com.mt.generatepassport.exceptions.RepositoryException;

public interface PersonRepository {

	void registerPerson(Person person, Passport passport) throws RepositoryException;

	int getPassportId(int id) throws RepositoryException;

	Passport getPassport(int passport_id) throws RepositoryException;

	List<Person> getPersons() throws RepositoryException;

}
