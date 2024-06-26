package com.comcast.genric.java.utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	// generate random number
	public int getRandomInteger() {
		Random random = new Random(); // to generate the random numbers every time
		int randomInteger = random.nextInt(5000); // Setting the upper limit (1 to 1000)
		return randomInteger;
	}

	// get system date
	public String getSystemDateYYYYMMDD() {
		Date date = new Date();
		SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd");
		String systemDate = sfd.format(date);
		return systemDate;

	}
	//get After  or  before date
		public String getRequiredDateYYYYMMDD(int days) {
			SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal= Calendar.getInstance();
			cal.add(Calendar.DAY_OF_MONTH,days);
			String requiredDate = sfd.format(cal.getTime());
			return requiredDate;

		}
}
