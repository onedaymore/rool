package test;

import util.YourMap;

public class NpTe {

	public static void main(String[] args) {
		YourMap<String, String> yp = new YourMap<String, String>();
		yp.put("A", "1");
		yp.put("B", "2");
		System.out.println(yp.size());
		
		String s = yp.get("A");
		String s2 = yp.get("B");
	}
}
