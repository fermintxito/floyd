package main.common;

import static java.util.Objects.isNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import main.Floyd;

public class CommonApiFile {

	private static final String INF = "-";

	public static int[][] readFile(String filename) {
		int[][] A = null;

		try {
			File myObj = new File(filename);
			Scanner myReader = new Scanner(myObj);

			int i = 0;
			while (myReader.hasNextLine()) {
				int j = 0;
				String data = myReader.nextLine();
				String[] split = data.split(" ");

				if (isNull(A)) {
					int l = split.length;
					A = new int[l][l];
				}

				int value = 0;
				for (String s : split) {
					switch (s) {
					case INF:
						value = Floyd.INF;
						break;
					default:
						value = Integer.valueOf(s);
						break;
					}

					A[i][j] = value;
					j++;
				}

				i++;
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.\r\n");
			e.printStackTrace();
		}

		return A;
	}

	public static void createAndWriteFile(String filename, String text) {
		if (!isNull(filename)) {
			createFile(filename);
			writeToFile(filename, text);
		}
	}

	public static void createFile(String filename) {
		try {
			File myObj = new File(filename);
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName() + "\r\n");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.\r\n");
			e.printStackTrace();
		}
	}

	public static void writeToFile(String filename, String text) {
		try {
			FileWriter myWriter = new FileWriter(filename);
			myWriter.write(text);
			myWriter.close();
			System.out.println("Successfully wrote to the file: " + filename + "\r\n");
		} catch (IOException e) {
			System.out.println("An error occurred.\r\n");
			e.printStackTrace();
		}
	}
}
