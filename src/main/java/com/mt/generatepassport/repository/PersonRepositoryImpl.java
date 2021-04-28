package com.mt.generatepassport.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.mt.generatepassport.entities.Passport;
import com.mt.generatepassport.entities.Person;
import com.mt.generatepassport.exceptions.RepositoryException;

public class PersonRepositoryImpl implements PersonRepository{

	public void registerPerson(Person person, Passport passport) throws RepositoryException {
		
		Connection connection = null;
		int result = 0;
		PreparedStatement statement1 = null;
		PreparedStatement statement2 = null;
		try {
			
			connection = GetConnection.getConnection();

			String query1 = "Insert into passport(id, passport_no, issue_place, date_issued) values(?,?,?,?)";
			statement1 = connection.prepareStatement(query1);
			statement1.setInt(1, passport.getId());
			statement1.setInt(2, passport.getPassportNo());
			statement1.setString(3, passport.getIssuePlace());
			statement1.setString(4, passport.getDate());
			result = statement1.executeUpdate();
			

			String query2 = "Insert into person(id, name, age, gender, passport_id) values(?,?,?,?,?);";
			statement2 = connection.prepareStatement(query2);
			statement2.setInt(1, person.getId());
			statement2.setString(2, person.getName());
			statement2.setInt(3,person.getAge());
			statement2.setString(4, person.getGender());
			statement2.setInt(5, passport.getId());
			result = statement2.executeUpdate();
			
		} catch(SQLException | RepositoryException | NoSuchElementException e) {
			throw new RepositoryException("Could not insert the person", e);
		}
		finally {
			try {
				statement1.close();
				statement2.close();
				connection.close();
			} catch (SQLException e) {
				throw new RepositoryException("Could not close connection",e);
			}
		}
		System.out.println("Person saved");
	}

	public int getPassportId(int id) throws RepositoryException {
		
		Connection connection = null;
		ResultSet result = null;
		PreparedStatement statement1 = null;
		int passportId = 0;
		
		try {
			connection = GetConnection.getConnection();
			String query1 = "Select * from person where id = ?";
			statement1 = connection.prepareStatement(query1);
			statement1.setInt(1, id);
			result = statement1.executeQuery();
			
			while(result.next()) {
				passportId = result.getInt(5);
			}
			
		} catch(SQLException | RepositoryException | NoSuchElementException e) {
			throw new RepositoryException("Could not fetch the passport id",e);
		}
		finally {
			try {
				result.close();
				statement1.close();
				connection.close();
			} catch (SQLException e) {
				throw new RepositoryException("Could not close connection",e);
			}
		}
		return passportId;
	}

	public Passport getPassport(int passportId) throws RepositoryException {
		
		Connection connection = null;
		ResultSet result = null;
		PreparedStatement statement1 = null;
		Passport passport = null;
		
		try {
			connection = GetConnection.getConnection();
			String query1 = "Select * from passport where id = ?";
			statement1 = connection.prepareStatement(query1);
			statement1.setInt(1, passportId);
			result = statement1.executeQuery();
			
			while(result.next()) {
				passport = new Passport(result.getInt(1), result.getInt(2), result.getString(3), result.getString(4));
			}
			
		} catch(SQLException | RepositoryException | NoSuchElementException e) {
			throw new RepositoryException("Could not fetch the passport id",e);
		}
		finally {
			try {
				result.close();
				statement1.close();
				connection.close();
			} catch (SQLException e) {
				throw new RepositoryException("Could not close connection", e);
			}
		}
		return passport;
	}

	public List<Person> getPersons() throws RepositoryException {
		
		Connection connection = null;
		ResultSet result = null;
		PreparedStatement statement1 = null;
		List<Person> persons = new ArrayList<>();
		
		try {
			
			connection = GetConnection.getConnection();
			String query1 = "Select * from person";
			statement1 = connection.prepareStatement(query1);
			result = statement1.executeQuery();
			
			while(result.next()) {
				Person person = new Person(result.getInt(1), result.getString(2), result.getInt(3), result.getString(4));
				persons.add(person);
			}
			
		} catch(SQLException | RepositoryException | NoSuchElementException e) {
			throw new RepositoryException("Could not fetch the passport id", e);
		}
		finally {
			try {
				result.close();
				statement1.close();
				connection.close();
			} catch (SQLException e) {
				throw new RepositoryException("Could not close connection", e);
			}
		}
		return persons;
	}
		
}
