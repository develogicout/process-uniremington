/**
 * 
 */
package com.uniremington.process;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.apache.log4j.Logger;

import com.uniremington.util.IProjectConstats;

/**
 * @author devnix
 *
 */
public class ReadFile implements IProjectConstats {

	static final Logger LOG = Logger.getLogger(ReadFile.class);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			archivo = new File(PATH_FILE_TEST);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null)
				LOG.info(linea);
		} catch (Exception e) {
			LOG.error(e.getMessage());
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				LOG.error(e2.getMessage());
			}
		}
	}
}
