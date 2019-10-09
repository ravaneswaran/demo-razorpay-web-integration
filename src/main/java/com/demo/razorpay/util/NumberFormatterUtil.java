package com.demo.razorpay.util;

public class NumberFormatterUtil {

	public static final String getFormattedString(long input) {
		int length = String.valueOf(input).length();
		switch (length) {
		case 1:
			return input + ".00";
		case 2:
			return input + ".00";
		case 3:
			return input + ".00";
		case 4:{
			int quotient = (int) input / 10;
			int remainder = (int) input % 10;
			
			return String.format("%s.%s0", quotient, remainder);
		}
		case 5:{
			int quotient = (int) input / 100;
			int remainder = (int) input % 100;
			
			return String.format("%s.%s0", quotient, remainder);
		}
		case 6:{
			int quotient = (int) input / 100;
			int remainder = (int) input % 100;
			
			return String.format("%s.%s0", quotient, remainder);
		}
		case 7:{
			int quotient = (int) input / 100;
			int remainder = (int) input % 100;
			
			return String.format("%s.%s", quotient, remainder);
		}
		}
		
		return "";
	}
}
