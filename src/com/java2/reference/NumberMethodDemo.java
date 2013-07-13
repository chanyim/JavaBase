package com.java2.reference;

public class NumberMethodDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		byte b = 5;
		int i = 10;
		double d = 10.0;
		float f = 10.0f;
		long l = 10L;
		short s = 10;
		String str = "chenzhiyan";
		Integer it = new Integer(10);
		
		Float f1 = new Float(f);
		Float f2 = new Float(d);
		Integer i2 = 10;
		/*try {
			Float f3 = new Float(str);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}*/
		
		Double d1 = new Double(d);
		
		/*try {
			Double d2 = new Double(str);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}*/
		
		System.out.println("f1 -> " + f1 + "\n" + "f1 -> " + f2);
	}

}
