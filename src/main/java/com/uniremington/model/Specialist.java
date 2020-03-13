/**
 * 
 */
package com.uniremington.model;

import java.time.LocalDate;

/**
 * @author devnix
 *
 */
public class Specialist extends Person {
	
	public String cargo;
	
	public Specialist () {
	}

	/**
	 * @return the cargo
	 */
	public String getCargo() {
		return cargo;
	}

	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	


	/**
	 * @param firstName
	 * @param secondName
	 * @param surname
	 * @param secondSurname
	 * @param birthDay
	 * @param gender
	 * @param cargo
	 */
	public Specialist(String firstName, String secondName, String surname, String secondSurname, LocalDate birthDay,
			String gender, String cargo) {
		super(firstName, secondName, surname, secondSurname, birthDay, gender);
		this.cargo = cargo;
	}
	
	@Override
	public void setData(String key, String value) {
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

		case "cargo":
			setCargo(value);
			break;
		default:
			break;
		}
	}
	
	
	public String getNombreYCargo() {
		String response = new String();
		if (firstName != null) response += firstName;
		if (secondName != null) response += " " + secondName;
		if (cargo != null) response += ", " + cargo;		
		return response;
	}

	
	@Override
	public String toString() {
		String response = "#	Especialista seleccionado \n";
		
		if (cargo != null) response += "#	cargo:	" + cargo +"\n";
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
