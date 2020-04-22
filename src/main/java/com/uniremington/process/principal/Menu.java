/**
 * 
 */
package com.uniremington.process.principal;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.uniremington.model.Person;
import com.uniremington.model.customthrows.OptionException;
import com.uniremington.process.MatrizOfClass;
import com.uniremington.process.Process;
import com.uniremington.process.ReadFile;
import com.uniremington.process.WriteCaptureFile;
import com.uniremington.util.IProjectConstats;

/**
 * @author devnix
 * @version 0.0.1
 *
 */
public class Menu implements IProjectConstats {
	
	private static Scanner sc = new Scanner(System.in);
	private static final Logger LOG = Logger.getLogger(Menu.class);
	private static int option, attempts = 3;
	private static String[] data = {"firstName","surname"};

	/**
	 * Método principal de la clase Menu
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * repite el proceso hasta que el usuario requiera salir
		 */
		do {
			LOG.info("Bienvenido al parcial");
			Menu mn = new Menu();
			mn.printOptions();
			mn.inputOptions();
			mn.process();			
		} while(option != MENU_OPTIONS.length-1);
		LOG.info("Fin del proceso");
		
	}
	
	/**
	 * Imprime las opciones del menú
	 * @globalVariable  MENU_OPTIONS
	 * 
	 */
	private void printOptions() {
		for (int i = 0; i < MENU_OPTIONS.length; i++) {
			LOG.info(i + ") " + MENU_OPTIONS[i]);
		}
	}
	
	/**
	 * Captura y verifica la opción del usuario
	 * 
	 * @globalVariable option
	 * @globalVariable sc
	 */
	private void inputOptions() {
		boolean complete = false, error = false;
		int count = 0;
		/**
		 * repite el proceso hasta que se complete o se acaben los intentos
		 * @method validateAttempts
		 */
		do {
			try {
				sc = new Scanner(System.in);
				LOG.info("Ingresar opción: ");
				option = sc.nextInt();
				if(option >= 0 && option < MENU_OPTIONS.length) {
					complete = true;					
				} else {
					/**
					 * Se ejecuta un custom throw (error personalizado)
					 */
					throw new OptionException(MSG_INVALID_OPTION);
				}
				LOG.info(MSG_PROCESSING);
				
			} catch (OptionException oe) {
				count++;
				error = validateAttempts(count);
				LOG.error(oe.getMessage());
			} catch (InputMismatchException e) {
				count++;
				error = validateAttempts(count);
				LOG.error(MSG_INVALID_OPTION);
			}			
		} while(!complete && !error);
	}
	
	/**
	 * 
	 * @param count
	 * @return
	 */
	private boolean validateAttempts(int count) {
		if (count >= attempts) {
			/**
			 * activa la opción salir para finalizar la aplicación
			 */
			option = MENU_OPTIONS.length-1;
			return true;
		}
		return false;
	}
	
	/**
	 * Ejecuta los procesos según la opción seleccionada
	 * @globalVariable 	option
	 * @class 			com.uniremington.model.Person
	 * @class 			com.uniremington.Process
	 * 
	 */
	
	@SuppressWarnings("static-access")
	private void process() {
		if(option >= 0 && option < MENU_OPTIONS.length) {
			LOG.info(MENU_OPTIONS[option]);			
		}
		switch (option) {
		case 0:
			printFields();
			break;
		case 1:
			Process.pedirDatos(data);
			Process.print();
			break;
		case 2:
			MatrizOfClass.loadData();
			MatrizOfClass.print();
			MatrizOfClass.printLastRow();		
			break;
		case 3:
			WriteCaptureFile.main(null);
			break;
		case 4:
			ReadFile.main(null);
			break;
		case 5:
			break;
		default:
			break;
		}
	}
	
	private void printFields() {
		Field[] fields = Person.class.getFields();
		HashMap<Integer, String> tempFields = new HashMap<>();
		boolean complete = false, error = false;
		int att = 0, res = 0;
		do {
			int count = 0;
			LOG.info("Campos actuales que se solicitan al usuario: " + Arrays.toString(data));
			LOG.info("Ingrese la opción del campo que requiere agregar");
			for (Field field : fields) {
				if(validateField(field.getName())) {
					count++;
					tempFields.put(count, field.getName());
					LOG.info(count + ") " + field.getName());
				}
			}
			if(count == 0) {
				LOG.warn("No quedan más campos por ingresar");
				complete = true;
			} else {
				count++;
				LOG.info(count + ") Salir");
				
				try {
					sc = new Scanner(System.in);
					res = sc.nextInt();
					if(res > count || res <= 0) throw new OptionException(MSG_INVALID_OPTION);
					if(res == count) {
						complete = true;
					} else {
						addField(tempFields.get(res));					
					}
				} catch (OptionException oe) {
					att++;
					error = validateAttempts(att);
					LOG.error(oe.getMessage());
				} catch (InputMismatchException e) {
					att++;
					error = validateAttempts(att);
					LOG.error(MSG_INVALID_OPTION);
				}
			}
			
		} while(!complete && !error);
	}
	
	private void addField(String nameField) {
		LOG.info("new field: " + nameField);
		String newData[] = new String[data.length+1];
		for (int i = 0; i < data.length; i++) {
			newData[i] = data[i];
		}
		newData[data.length] = nameField;
		data = newData;
	}
	
	private boolean validateField(String field) {
		for (String string : data) {
			if(string == null) string = "";
			if(string.equalsIgnoreCase(field)) {
				return false;
			}
		}
		return true;
	}
}
