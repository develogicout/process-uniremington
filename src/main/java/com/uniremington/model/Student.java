package com.uniremington.model;

import java.time.LocalDate;

public class Student extends Person {
	
	public String matter;
	public String classroom;
	public String teacher;
	public int hour;
	
	/**
	 * @category empty builder
	 */
	public Student() {
		
	}
	
	/**
	 * @param firstName
	 * @param secondName
	 * @param surname
	 * @param secondSurname
	 * @param birthDay
	 * @param gender
	 */
	public Student(String firstName, String secondName, String surname, String secondSurname, LocalDate birthDay,
			String gender) {
		super(firstName, secondName, surname, secondSurname, birthDay, gender);
	}

	/**
	 * @param firstName
	 * @param secondName
	 * @param surname
	 * @param secondSurname
	 * @param birthDay
	 * @param gender
	 * @param matter
	 * @param classroom
	 * @param teacher
	 * @param hour
	 */
	public Student(String firstName, String secondName, String surname, String secondSurname, LocalDate birthDay,
			String gender, String matter, String classroom, String teacher, int hour) {
		super(firstName, secondName, surname, secondSurname, birthDay, gender);
		this.matter = matter;
		this.classroom = classroom;
		this.teacher = teacher;
		this.hour = hour;
	}

	/**
	 * load data by field name
	 */
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
		case "matter":
			setMatter(value);
			break;
		case "classroom":
			setClassroom(value);
			break;
		case "hour":
			setHour(value);
			break;
		case "teacher":
			setTeacher(value);
			break;
		default:
			break;
		}
	}

	/**
	 * @return the matter
	 */
	public String getMatter() {
		return matter;
	}

	/**
	 * @param matter the matter to set
	 */
	public void setMatter(String matter) {
		this.matter = matter;
	}

	/**
	 * @return the classroom
	 */
	public String getClassroom() {
		return classroom;
	}

	/**
	 * @param classroom the classroom to set
	 */
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	/**
	 * @return the hour
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * @param hour the hour to set
	 */
	public void setHour(String hour) {
		try {
			this.hour = Integer.parseInt(hour);			
		} catch (NumberFormatException e) {
			this.hour = 0;
			LOG.error(e.getMessage());
		}
	}

	/**
	 * @return the teacher
	 */
	public String getTeacher() {
		return teacher;
	}

	/**
	 * @param teacher the teacher to set
	 */
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
	@Override
	public String toString() {
		String response = "#	Estudiante \n";
		
		if (firstName != null) response += "#	firstName:	" + firstName +"\n";
		if (secondName != null) response += "#	secondName:	" + secondName +"\n";
		if (surname != null) response += "#	surname:	" + surname +"\n";
		if (secondSurname != null) response += "#	secondSurname:	" + secondSurname +"\n";
		if (birthDay != null) response += "#	birthDay:	" + birthDay +"\n";
		if (gender != null) response += "#	gender:	" + gender +"\n";
		if (matter != null) response += "#	matter:	" + matter +"\n";
		if (classroom != null) response += "#	classroom:	" + classroom +"\n";
		if (teacher != null) response += "#	teacher:	" + teacher +"\n";
		if (hour != 0) response += "#	hour:	" + hour +"\n";
		response += "############################################";
		return response;
    }

	
	
}