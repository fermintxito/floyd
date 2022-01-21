package main.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonApiDate {
	public static String dateNowToString() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss.SSS");

		return dateFormat.format(date);
	}
}
