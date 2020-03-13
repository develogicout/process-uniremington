/**
 * 
 */
package com.uniremington.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;

/**
 * @author devnix
 *
 */
public class Person {
	
	static final Logger LOG = Logger.getLogger(Person.class);

	public String firstName;
	public String secondName;
	public String surname;
	public String secondSurname;
	public LocalDate birthDay;
	public String gender;

	/**
	 * @param firstName
	 * @param secondName
	 * @param surname
	 * @param secondSurname
	 * @param birthDay
	 * @param gender
	 */
	public Person(String firstName, String secondName, String surname, String secondSurname, LocalDate birthDay,
			String gender) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.surname = surname;
		this.secondSurname = secondSurname;
		this.birthDay = birthDay;
		this.gender = gender;
	}

	public Person() {
	}

	public void hacer(String action) {
		LOG.info("hacer " + action);
	}

	public void ejecutar(String action) {
		LOG.info("ejecutar " + action);
	}

	public void solicitar(String action) {
		LOG.info("solicitar " + action);
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the secondName
	 */
	public String getSecondName() {
		return secondName;
	}

	/**
	 * @param secondName the secondName to set
	 */
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the secondSurname
	 */
	public String getSecondSurname() {
		return secondSurname;
	}

	/**
	 * @param secondSurname the secondSurname to set
	 */
	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	/**
	 * @return the birthDay
	 */
	public LocalDate getBirthDay() {
		return birthDay;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		Period periodo = null;
		try {
			if(birthDay != null) {
				LocalDate fechaActual = LocalDate.now();
				periodo = Period.between(birthDay, fechaActual);			
				return periodo.getYears();				
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return 0;
	}

	/**
	 * @param birthDay the birthDay to set
	 */
	public void setBirthDay(String date) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.birthDay = LocalDate.parse(date, format);
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setData(String key, String value) {
		try {
			switch (key) {
			case "firstName":
				setFirstName(value);
				break;
			case "secondName":
				setSecondName(value);
				break;
			case "surname":
				setSurname(value);
				break;
			case "secondSurname":
				setSecondSurname(value);
				break;
			case "birthDay":
				setBirthDay(value);
				break;
			case "gender":
				setGender(value);
				break;
			default:
				break;
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
	}


	@Override
	public String toString() {
		String response = "#	Datos del usuario \n";
		
		if (firstName != null) response += "#	firstName:	" + firstName +"\n";
		if (secondName != null) response += "#	secondName:	" + secondName +"\n";
		if (surname != null) response += "#	surname:	" + surname +"\n";
		if (secondSurname != null) response += "#	secondSurname:	" + secondSurname +"\n";
		if (birthDay != null) response += "#	birthDay:	" + birthDay +"\n";
		if (gender != null) response += "#	gender:	" + gender +"\n";
		response += "############################################";
		return response;
	}

}
