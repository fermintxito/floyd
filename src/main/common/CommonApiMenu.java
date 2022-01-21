package main.common;

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

	public int[][] showInputMenu() {
		return new int[0][0];
	}
}
