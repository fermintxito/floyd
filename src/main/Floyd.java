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

	static void Floyd2(int[][] A, int N)
    {
		int[][] M = new int [N][N];
		int[][] rutas = new int [N][N];

        int i,j,k,tmp;
        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                M[i][j] = A[i][j];
                rutas[i][j] = 0;
            }
        }
        for (k = 0; k < N; k++) {
            for (i = 0; i < N; i++) {
                for (j = 0; j < N; j++) {
                    tmp = M[i][k] + M[k][j];
                    if(tmp < M[i][j]){
                        M[i][j] = tmp;
                        rutas[i][j] = k;
                    }
                }
            }
        }
    }
	
	static void VerRutas(int[][] A, int N)
    {
        int i,j;
        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                if(M[i][j] != IHelper.INF){
                    System.out.print("["+(i+1)+", "+(j+1)+"]: ");
                    System.out.print((i+1)+",");
                    ImprimeRutaRec(i,j);
                    System.out.print((j+1)+": ");
                    System.out.print(M[i][j]);
                    
                    System.out.println();
                }
            }
        }
    }

    static void ImprimeRutaRec(int i, int j){
        int k;
        k = rutas[i][j];
        if(k != 0){
            ImprimeRutaRec(i,k);
            System.out.print((k+1)+",");
            ImprimeRutaRec(k,j);
        }
    }
}
