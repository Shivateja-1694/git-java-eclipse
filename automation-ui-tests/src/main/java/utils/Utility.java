package utils;

import java.util.Random;

public class Utility {
	
	public static final int implicitWait = 10;
	
	public static String randomNumbers() {
	Random r = new Random();
	int eID = r.nextInt(1000);
	String email = "tallashiva"+eID+"@gmail.com";
	return email;
	}


}
