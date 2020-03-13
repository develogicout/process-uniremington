/**
 * 
 */
package com.uniremington.process;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.uniremington.model.Person;
import com.uniremington.model.Student;

/**
 * @author devnix
 *
 */
public class cicloWhile {
	
	static Scanner sc = new Scanner(System.in);
	static final Logger LOG = Logger.getLogger(cicloWhile.class);
	static int count;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] requestFields;
		
		writeUserData();
		writeSchoolData(2);
		requestFields = new String[]{"firstName","matter","classroom","teacher","hour"};
		enterStudents(3, requestFields);
		
		LOG.info("############################################");
		LOG.info("#	¡Process End!");
		LOG.info("############################################\n");
	}
	
	public static void writeUserData() {
		count = 0;
		Person usuario = new Person();
		Field[] fields = usuario.getClass().getFields();
		
		int countFields = fields.length;
		
		String[] usuarioCampos = {"firstName","surname","birthDay"};
		while (count <= countFields-1) {
			if(Process.required(usuarioCampos, fields[count].getName())) {
				LOG.info("Write the " + fields[count].getName());
				usuario.setData(fields[count].getName(), sc.nextLine());
			}
			count++;
		}
		
		LOG.info("############################################");
		LOG.info(usuario.toString());
	}
	
	public static void writeSchoolData(int quantity) {
		count = 0;
		List<String[]> schoolList = new ArrayList<String[]>();
		while (count < quantity) {
			LOG.info("############################################");
			LOG.info("#	school #" + (count+1));
			String[] school = new String[2];
			sc = new Scanner(System.in);
			LOG.info("Write the school name: ");
			school[0] = sc.nextLine();
			LOG.info("Write the school addres: ");
			school[1] = sc.nextLine();
			schoolList.add(school);
			count++;
		}
		
		LOG.info("\n\n#	Abstract\n");
		for (int i = schoolList.size(); i > 0 ; i--) {
			if ((i) % 2 == 0) {
				LOG.info("############################################");
				LOG.info("#	school #" + (i));
				LOG.info("#	The school name is " + schoolList.get(i-1)[0].toString());
				LOG.info("#	The school addres is " + schoolList.get(i-1)[1].toString());
				LOG.info("############################################\n");
			}
		}
	}
	
	/**
	 * 
	 * @param requestFields ({"matter","classroom","teacher","hour"})
	 * @return Student
	 */
	public static Student writeStudentData(String[] requestFields) {
		count = 0;
		Student student = new Student();
		Field[] fields = student.getClass().getFields();		
		int countFields = fields.length;
		while (count <= countFields-1) {
			if(Process.required(requestFields, fields[count].getName())) {
				LOG.info("Write the " + fields[count].getName());
				student.setData(fields[count].getName(), sc.nextLine());
			}
			count++;
		}
		return student;
	}
	
	public static void enterStudents(int quantity, String[] requestFields) {
		int count1 = 0;
		List<Student> studentList = new ArrayList<Student>();
		while (count1 < quantity) {
			LOG.info("############################################\n");
			LOG.info("#	student #" + (count1+1));
			studentList.add(writeStudentData(requestFields));
			count1++;
		}
		
		for (Student student : studentList) {
			LOG.info(student.toString());			
		}
		LOG.info("\n############################################");
	}

}
