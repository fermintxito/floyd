package main;

import static java.util.Objects.isNull;

import main.common.CommonApiFile;
import main.common.CommonApiMenu;

public class Floyd {

	public static final int INT_INF = 9999;
	public static final String STR_INF = "-";

	public int[][] M = new int[0][0];
	public int[][] rutas = new int[0][0];

//	public static void run(String inputFile, String outputFile, boolean showTrace) {
//		Building[] buildings = CommonApiFile.readFile(inputFile);
//		ArrayList<Skyline> skylines = obtenerSkyLines(buildings, 0, (buildings.length - 1), showTrace);
//
//		boolean isFirst = true;
//		StringBuilder sb = new StringBuilder();
//		sb.append("{");
//		for (Skyline s : skylines) {
//			if (isFirst) {
//				isFirst = false;
//			} else {
//				sb.append(",");
//			}
//
//			sb.append("(");
//			sb.append(s.abscisa + "," + s.height);
//			sb.append(")");
//
//		}
//		sb.append("}");
//
//		CommonApiFile.createAndWriteFile(outputFile, sb.toString());
//	}

	public void run(String inputFile, String outputFile, boolean showTrace) {
		int[][] A = null;
		if (!isNull(inputFile)) {
			A = CommonApiFile.readFile(inputFile);
		} else {
			A = CommonApiMenu.showInputMenu();
		}

		int N = 0;
		for (int[] ints : A) {
			N = ints.length;
		}

		this.M = new int[N][N];
		this.rutas = new int[N][N];

		int i, j, k, tmp;
		for (i = 0; i < N; i++) {
			for (j = 0; j < N; j++) {
				this.M[i][j] = A[i][j];
				this.rutas[i][j] = 0;
			}
		}
		for (k = 0; k < N; k++) {
			for (i = 0; i < N; i++) {
				for (j = 0; j < N; j++) {
					tmp = this.M[i][k] + this.M[k][j];
					if (tmp < this.M[i][j]) {
						this.M[i][j] = tmp;
						this.rutas[i][j] = k;
					}
				}
			}
		}

		String result = VerRutas(A, N);

		if (!isNull(outputFile)) {
			CommonApiFile.createAndWriteFile(outputFile, result);
		} else {
			System.out.println(result);
		}
	}

	private String VerRutas(int[][] A, int N) {
		StringBuilder sb = new StringBuilder();

		int i, j;
		for (i = 0; i < N; i++) {
			for (j = 0; j < N; j++) {
				if (this.rutas[i][j] != INT_INF) {
					sb.append("[" + (i + 1) + ", " + (j + 1) + "]: ");
					sb.append((i + 1) + ",");
					sb.append(ImprimeRutaRec(i, j));
					sb.append((j + 1) + ": ");
					sb.append(this.M[i][j]);
					sb.append("\r\n");
				}
			}
		}

		return sb.toString();
	}

	private String ImprimeRutaRec(int i, int j) {
		StringBuilder sb = new StringBuilder();

		int k = this.rutas[i][j];
		if (k != 0) {
			sb.append(ImprimeRutaRec(i, k));
			sb.append((k + 1) + ",");
			sb.append(ImprimeRutaRec(k, j));
		}

		return sb.toString();
	}
}
