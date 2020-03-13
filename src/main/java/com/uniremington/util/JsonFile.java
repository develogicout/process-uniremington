/**
 * 
 */

package com.uniremington.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.uniremington.model.Specialist;

/**
 * @author DEVNIX
 *
 */
public class JsonFile implements IProjectConstats {

	private static final Logger	LOG	= Logger.getLogger(JsonFile.class);
	
	public static Specialist[] loadFile() {
		try (InputStream is = new URL("file:///D:/1_workspace/springTools/estudio/Consultorio/src/main/java/com/uniremington/process/especialistas.json").openStream()) {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			StringBuilder sb = new StringBuilder();
			int cp;
			while ((cp = rd.read()) != -1) {
				sb.append((char) cp);
			}
			
			Gson gson = new Gson();
			
			/**
			 * save json
			 */
			Specialist[] list = gson.fromJson(sb.toString(), Specialist[].class);
			is.close();
			return list;
		} catch (IOException e) {
			LOG.error(MSG_GENERIC_ERROR + "[" + e.getMessage() + "]");
		}
		return null;
	}

}
