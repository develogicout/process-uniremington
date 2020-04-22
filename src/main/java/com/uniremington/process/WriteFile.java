/**
 * 
 */
package com.uniremington.process;

import java.io.FileWriter;
import java.io.PrintWriter;

import org.apache.log4j.Logger;

import com.uniremington.util.IProjectConstats;

/**
 * @author devnix
 *
 */
public class WriteFile implements IProjectConstats {

	static final Logger LOG = Logger.getLogger(WriteFile.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter(PATH_FILE_TEST, true);
			pw = new PrintWriter(fichero);

			for (int i = 0; i < 10; i++) {
				pw.println("Nixon " + i);				
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
