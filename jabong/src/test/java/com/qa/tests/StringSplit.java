package com.qa.tests;

public class StringSplit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "welcome, Admin, Shital";
		System.out.println(str);
		String[] splitStr = str.split(",");
		
		for(int i=0; i < splitStr.length; i++){
			
			System.out.println(splitStr[i]);
		}
		
		System.out.println(splitStr[0]);
		
		System.exit(0);
	}

}
