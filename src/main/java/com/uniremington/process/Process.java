/**
 * 
 */
package com.uniremington.process;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.uniremington.model.Action;
import com.uniremington.model.Person;
import com.uniremington.model.Specialist;
import com.uniremington.util.JsonFile;

/**
 * @author devnix
 *
 */
public class Process implements Action {

	static Scanner sc = new Scanner(System.in);
	static final Logger LOG = Logger.getLogger(Process.class);
	static int specialist = 0;
	private static Person user = new Person();		

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		try {
			String[] userFields = {"firstName","surname","birthDay"};
			requestData(userFields);
			LOG.info("############################################");
			LOG.info(user.toString());
			
			Specialist[] list = JsonFile.loadFile();
			
			
			do {
				LOG.info("#	Ingrese el numero del especialista");
				for (int i = 0; i < list.length; i++) {
					LOG.info("#	 " + (i + 1)  + ") " + list[i].getNombreYCargo());
					
				}
			} while (!validateScInt(list.length));
			
			
			
			LOG.info("############################################");
			LOG.info(user.toString());
			LOG.info(list[specialist-1].toString());
			LOG.info("###	Proceso finalizado           	####");
			LOG.info("############################################");
			
		} catch (Exception e) {
			LOG.error("error: " + e.getMessage());
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}
		
	public static void requestData(Specialist specialist, String[] data) {
		sc = new Scanner(System.in);
		try {
			Field[] fields = specialist.getClass().getFields();
			LOG.info("#	Ingrese los datos del especialista");
			for (Field field : fields) {
				if(required(data, field.getName())) {
					LOG.info("#	" + field.getName() + ": ");
					sc = new Scanner(System.in);
					specialist.setData(field.getName(), sc.next());
				}
			}
			System.out.print ('\f');
		} catch (Exception e) {
			LOG.error(e.getMessage());
		} 
	}

	public static Person requestData(String[] data) {
		sc = new Scanner(System.in);
		user = new Person();
		try {
			Field[] fields = user.getClass().getFields();
			LOG.info("#############################################");
			LOG.info("###	Formato solicitud datos del usuario	####");
			LOG.info("#############################################");
			LOG.info("#	Ingrese los datos del usuario");
			for (Field field : fields) {
				if(required(data, field.getName())) {
					LOG.info("#	" + field.getName() + ": ");
					sc = new Scanner(System.in);
					user.setData(field.getName(), sc.next());
				}
			}
			System.out.print ('\f');
		} catch (Exception e) {
			LOG.error(e.getMessage());
		} 
		return user;
	}
	
	public static boolean required(String[] data, String value) {
		for (String string : data) {
			if(string.equalsIgnoreCase(value)) {
				return true;
			}
		}
		return false;
	}	
	
	public static boolean validateScInt (int limit) {
		try {
			sc = new Scanner(System.in);
			specialist = sc.nextInt();
			return (specialist <= limit) ? true : false;
		} catch (Exception e) {
			LOG.error("error: " + e.getMessage());
		}
		return false;
	}

	public static void print() {
		LOG.info(user.toString());
	}
	
	

}
