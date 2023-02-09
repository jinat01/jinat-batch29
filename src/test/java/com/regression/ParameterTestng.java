package com.regression;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTestng {
	
	@Test
	@Parameters({"URL","user","password"})
	public void getData(String URL,String user, String password) {
		System.out.println(URL);
		System.out.println(user);
		System.out.println(password);
	}

}
