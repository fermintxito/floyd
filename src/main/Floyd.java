package main;

import java.util.ArrayList;

import main.common.CommonApiFile;

public class Floyd {

	public static void run(String inputFile, String outputFile, boolean showTrace) {
		Building[] buildings = CommonApiFile.readFile(inputFile);
		ArrayList<Skyline> skylines = obtenerSkyLines(buildings, 0, (buildings.length - 1), showTrace);

		boolean isFirst = true;
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (Skyline s : skylines) {
			if (isFirst) {
				isFirst = false;
			} else {
				sb.append(",");
			}

			sb.append("(");
			sb.append(s.abscisa + "," + s.height);
			sb.append(")");

		}
		sb.append("}");

		CommonApiFile.createAndWriteFile(outputFile, sb.toString());
	}
}
