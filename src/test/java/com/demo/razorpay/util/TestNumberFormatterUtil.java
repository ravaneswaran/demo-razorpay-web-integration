package com.demo.razorpay.util;

import junit.framework.TestCase;

public class TestNumberFormatterUtil extends TestCase {
	
	public void testGetFormattedString_1() {
		long value = 1234l;
		String returnVal = NumberFormatterUtil.getFormattedString(value);
		assertEquals("123.40", returnVal);
	}
	
	public void testGetFormattedString_2() {
		long value = 12345l;
		String returnVal = NumberFormatterUtil.getFormattedString(value);
		assertEquals("123.45", returnVal);
	}
	
	public void testGetFormattedString_3() {
		long value = 123456l;
		String returnVal = NumberFormatterUtil.getFormattedString(value);
		assertEquals("1234.56", returnVal);
	}
	
	public void testGetFormattedString_4() {
		long value = 1234567l;
		String returnVal = NumberFormatterUtil.getFormattedString(value);
		assertEquals("12345.67", returnVal);
	}

}
