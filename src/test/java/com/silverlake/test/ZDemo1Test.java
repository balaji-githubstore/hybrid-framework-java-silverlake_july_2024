package com.silverlake.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//no need to do
//will be deleted
public class ZDemo1Test {
	@DataProvider
	public Object[][] demoValidData() {
		Object[][] data = new Object[3][2];

		// i-->number of testcase
		// j-->number of parameters
		data[0][0] = "Saul";
		data[0][1] = "saul124";

		data[1][0] = "peter";
		data[1][1] = "peter123";

		data[2][0] = "john";
		data[2][1] = "john123";

		return data;
	}

	@Test(dataProvider = "demoValidData")
	public void demoValidTest(String username, String password) {
		System.out.println("valid " + username + password);
	}
}
