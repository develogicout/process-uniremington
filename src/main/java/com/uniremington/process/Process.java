/**
 * 
 */
package com.uniremington.process;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.uniremington.model.Action;
import com.uniremington.model.Specialist;
import com.uniremington.model.Person;
import com.uniremington.util.JsonFile;

/**
 * @author devnix
 *
 */
public class Process implements Action {

	static Scanner sc = new Scanner(System.in);
	static final Logger LOG = Logger.getLogger(Process.class);
	static int especialista = 0;

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		try {
			Person usuario = new Person();		
			
			String[] usuarioCampos = {"firstName","surname","birthDay"};
			pedirDatos(usuario, usuarioCampos);
			LOG.info("############################################");
			LOG.info(usuario.toString());
			
			Specialist[] list = JsonFile.loadFile();
			
			
			do {
				LOG.info("#	Ingrese el numero del especialista");
				for (int i = 0; i < list.length; i++) {
					LOG.info("#	 " + (i + 1)  + ") " + list[i].getNombreYCargo());
					
				}
			} while (!validarScInt(list.length));
			
			
			
			LOG.info("############################################");
			LOG.info(usuario.toString());
			LOG.info(list[especialista-1].toString());
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
		
	public static void pedirDatos(Specialist especialista, String[] data) {
		sc = new Scanner(System.in);
		try {
			Field[] fields = especialista.getClass().getFields();
			LOG.info("#	Ingrese los datos del especialista");
			for (Field field : fields) {
				if(required(data, field.getName())) {
					LOG.info("#	" + field.getName() + ": ");
					sc = new Scanner(System.in);
					especialista.setData(field.getName(), sc.next());
				}
			}
			System.out.print ('\f');
		} catch (Exception e) {
			LOG.error(e.getMessage());
		} 
	}

	public static void pedirDatos(Person usuario, String[] data) {
		sc = new Scanner(System.in);
		try {
			Field[] fields = usuario.getClass().getFields();
			LOG.info("############################################");
			LOG.info("###	Formato solicitud cita médica	####");
			LOG.info("############################################");
			LOG.info("#	Ingrese los datos del usuario");
			for (Field field : fields) {
				if(required(data, field.getName())) {
					LOG.info("#	" + field.getName() + ": ");
					sc = new Scanner(System.in);
					usuario.setData(field.getName(), sc.next());
				}
			}
			System.out.print ('\f');
		} catch (Exception e) {
			LOG.error(e.getMessage());
		} 
	}
	
	public static boolean required(String[] data, String value) {
		for (String string : data) {
			if(string.equalsIgnoreCase(value)) {
				return true;
			}
		}
		return false;
	}	
	
	public static boolean validarScInt (int limit) {
		try {
			sc = new Scanner(System.in);
			especialista = sc.nextInt();
			return (especialista <= limit) ? true : false;
		} catch (Exception e) {
			LOG.error("error: " + e.getMessage());
		}
		return false;
	}

}
