/**
 * 
 */
package com.uniremington.process;

/**
 * @author devnix
 *
 */
public class Matrices {

	static int matriz[][] = new int[3][3];

	/**
	 * @param args
	 */

	public Matrices() {
		super();
	}

	public static void main(String[] args) {
//		ejemplo1();
		ejemplo2();
	}

	public static void ejemplo1() {
		matriz[0][0] = 2;
		matriz[0][1] = 3;
		matriz[0][2] = 4;
		matriz[1][0] = 5;
		matriz[1][1] = 6;
		matriz[1][2] = 7;
		matriz[2][0] = 8;
		matriz[2][1] = 10;
		matriz[2][2] = 12;

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.println(matriz[i][j]);
			}
		}
	}

	public static void ejemplo2() {
		final int filas = 3;
		final int columnas = 5;
		char[][] letras = new char[filas][columnas];
		char letraQueToca = 'A';

		for (int f = 0; f < filas; f++) {
			for (int c = 0; c < columnas; c++) {
				letras[f][c] = letraQueToca;
				letraQueToca++;
			}
		}

		for (int f = 0; f < filas; f++) {
			for (int c = 0; c < columnas; c++) {
				System.out.print(letras[f][c] + " ");
			}
			System.out.println();
		}
	}

}
