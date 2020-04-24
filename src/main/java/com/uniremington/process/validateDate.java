/**
 * 
 */
package com.uniremington.process;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.uniremington.model.ResponseWhatsapp;
import com.uniremington.process.principal.Menu;

/**
 * @author Ingenian
 *
 */
public class validateDate {
	private static Scanner sc = new Scanner(System.in);
	private static final Logger LOG = Logger.getLogger(Menu.class);
	
	private static final Date DATE = new Date(90900521);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info(getDate());
		List<String> data = new ArrayList<>();
		data.add("data1");
		data.add("data2");
		data.add("data3");
		ResponseWhatsapp rw = new ResponseWhatsapp(true, data, "3", "4", "5");
		LOG.info(rw.toString());
	}

	/**
	 * @return the date
	 */
	public static Date getDate() {
		return (Date) DATE.clone();
	}

	
	
}
