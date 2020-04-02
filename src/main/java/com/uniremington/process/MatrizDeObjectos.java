/**
 * 
 */
package com.uniremington.process;

import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * @author devnix
 *
 */
public class MatrizDeObjectos {
	
	static Scanner sc = new Scanner(System.in);
	static final Logger LOG = Logger.getLogger(MatrizDeObjectos.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("starting process");
		String print = "", fields = "";
		Object persons[][] = new Object[2][4];
		String[] data = {"firstName","surname","birthDay","gender"};
		for (int i = 0; i < data.length; i++) {
			fields += data[i] + "\t";
		}

		for (int i = 0; i < persons.length; i++) {
			LOG.info("new person");
			for (int j = 0; j < persons[i].length; j++) {
				sc = new Scanner(System.in);
				LOG.info("Enter " + data[j]);
				persons[i][j] = sc.nextLine();
				LOG.info(persons[i][j].toString());
				print += persons[i][j].toString() + "\t";
			}
			print += "\n";
		}
		
		LOG.info(fields + "\n" + print);		
		LOG.info("ending process");		
	}
}
