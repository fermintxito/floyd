package main.common;

public class CommonApiMenu {

	public static String showHelp() {
		StringBuilder sb = new StringBuilder();

		sb.append("SINTAXIS: skyline [-t][-h] [fichero entrada] [fichero salida]\r\n");
		sb.append("-t Traza cada llamada recursiva y sus parámetros\r\n");
		sb.append("-h Muestra esta ayuda\r\n");
		sb.append("[fichero entrada] Conjunto de edificios de la ciudad\r\n");
		sb.append("[fichero salida] Secuencia que representan el skyline de la ciudad\r\n");

		return sb.toString();
	}

	public static String showFileNames(String inputFile, String outputFile) {
		StringBuilder sb = new StringBuilder();

		sb.append("fichero entrada: " + inputFile + "\r\n");
		sb.append("fichero salida: " + outputFile + "\r\n");

		return sb.toString();
	}
}
