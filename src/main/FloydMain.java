package main;

import main.common.CommonApiDate;
import main.common.CommonApiMenu;

public class FloydMain {

	private static final String DEFAULT_OUTPUT = "pruebas/output/defaultOutput.txt";

	private static final String SHOW_TRACE = "-t";
	private static final String SHOW_HELP = "-h";

	private static boolean showTrace = false;
	
	public static void main(String[] args) {
		System.out.println(main.common.CommonApiDate.dateNowToString() + " || Launch Floyd\r\n");
		boolean isInput = true;

		String inputFile = null;
		String outputFile = DEFAULT_OUTPUT;

		if (args.length > 4) {
			System.out.println("Too much args, see [floyd -h] for help\r\n");
			return;
		} else if (args.length < 1) {
			System.out.println("Not enough arguments, see [floyd -h] for help\r\n");
			return;
		}

		for (String a : args) {
			switch (a) {
			case SHOW_TRACE:
				showTrace = true;
				continue;
			case SHOW_HELP:
				System.out.println(CommonApiMenu.showHelp());
				continue;
			}

			if (isInput) {
				inputFile = a;
				isInput = false;
			} else {
				outputFile = a;
			}
		}

		Floyd.run(inputFile, outputFile, showTrace);
		System.out.println(CommonApiDate.dateNowToString() + " || Close Floyd\r\n");
	}
}
