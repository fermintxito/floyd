package main.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import main.domain.Building;

public class CommonApiFile {
	public static Building[] readFile(String filename) {
		List<Building> edificios = new LinkedList<Building>();
		try {
			File myObj = new File(filename);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] split = data.split(",");
				edificios.add(new Building(Integer.parseInt(split[0]), Integer.parseInt(split[1]),
						Integer.parseInt(split[2])));
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.\r\n");
			e.printStackTrace();
		}

		return edificios.toArray(new Building[edificios.size()]);
	}

	public static void createAndWriteFile(String filename, String text) {
		createFile(filename);
		writeToFile(filename, text);
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
