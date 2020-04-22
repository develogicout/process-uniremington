/**
 * 
 */
package com.uniremington.process;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.uniremington.model.Person;

/**
 * @author Ingenian
 *
 */
public class MatrizOfClass {
	
	private static Scanner sc = new Scanner(System.in);
	private static final Logger LOG = Logger.getLogger(Process.class);
	private static Person[][] mat;
	private static String[] data = {"firstName","surname"};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		loadData();
		print();
		printLastRow();
	}

	public static void loadData() {
		sc = new Scanner(System.in);
		System.out.print("Cuantas fila tiene la matriz:");
		int filas = sc.nextInt();
		System.out.print("Cuantas columnas tiene la matriz:");
		int columnas = sc.nextInt();
		mat = new Person[filas][columnas];
		for (int f = 0; f < mat.length; f++) {
			for (int c = 0; c < mat[f].length; c++) {
				mat[f][c] = Process.pedirDatos(data);
			}
		}
	}

	public static void print() {
		for (int f = 0; f < mat.length; f++) {
			for (int c = 0; c < mat[f].length; c++) {
				System.out.print(mat[f][c].toString() + " ");
			}
			System.out.println();
		}
	}

	public static void printLastRow() {
		System.out.println("Ultima fila");
		for (int c = 0; c < mat[mat.length - 1].length; c++) {
			System.out.print(mat[mat.length - 1][c].toString() + " ");
		}
	}

	/**
	 * @return the data
	 */
	public static String[] getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public static void setData(String[] data) {
		MatrizOfClass.data = data;
	}

	/**
	 * @return the log
	 */
	public static Logger getLog() {
		return LOG;
	}
	
	

}
