package main.common;

import java.util.Scanner;

import main.Floyd;

public class CommonApiMenu {

	public static String showHelp() {
		StringBuilder sb = new StringBuilder();

		sb.append("SINTAXIS: floyd [-t][-h] [fichero entrada] [fichero salida]\r\n");
		sb.append("-t Traza el algoritmo\r\n");
		sb.append("-h Muestra esta ayuda\r\n");
		sb.append("[fichero entrada] Matriz de adyacencia que representa el grafo\r\n");
		sb.append(
				"[fichero salida] Para cada par de nodos: la lista de nodos del camino más corto y su valor o longitud\r\n");

		return sb.toString();
	}

	public static String showFileNames(String inputFile, String outputFile) {
		StringBuilder sb = new StringBuilder();

		sb.append("fichero entrada: " + inputFile + "\r\n");
		sb.append("fichero salida: " + outputFile + "\r\n");

		return sb.toString();
	}

	public static int[][] showInputMenu() {
		int N = 0;
		int[][] A = null;

		Scanner in = new Scanner(System.in);

		try {
			System.out.println("Introduce el orden de la matriz: ");
			N = Integer.valueOf(in.nextLine());

			A = new int[N][N];

			String msg = "";
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					msg = String.format("Introduce el valor [%d][%d] de la matriz: ", i + 1, j + 1);
					System.out.println(msg);
					String s = in.nextLine();

					int value = 0;
					switch (s) {
					case Floyd.STR_INF:
						value = Floyd.INT_INF;
						break;
					default:
						value = Integer.valueOf(s);
						break;
					}

					A[i][j] = value;
				}
			}
		} catch (Exception e) {
			System.out.println("!!No es un número válido¡¡");
		}

		// closing scanner
		in.close();
		return A;
	}
}
