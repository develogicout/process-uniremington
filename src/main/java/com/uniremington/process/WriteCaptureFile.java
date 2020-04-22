/**
 * 
 */
package com.uniremington.process;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.uniremington.util.IProjectConstats;

/**
 * @author devnix
 *
 */
public class WriteCaptureFile implements IProjectConstats {
	
	static Scanner sc = new Scanner(System.in);
	static final Logger LOG = Logger.getLogger(Process.class);
	static int especialista = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		sc = new Scanner(System.in);
		try {
			fichero = new FileWriter(PATH_FILE_TEST, true);
			pw = new PrintWriter(fichero);

			for (int c = 1; c < 5; c++) {
				LOG.info("Escriba dato " + c);
				String filas = sc.next();
				pw.println(filas);
			}

		} catch (Exception e) {
			LOG.error(e.getMessage());
		} finally {
			try {
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				LOG.error(e2.getMessage());
			}
		}
	}

}
