package com.mven.qa.testdata;

public class ImportantLoginData {
	
	private static String mobileNumber;
	private static String password;
	
	
	public ImportantLoginData() {
		
		ReadExcelFile file;
		try {
			file = new ReadExcelFile();
			Object[][] data = file.ReadExcelFile("C:\\Users\\LENOVO\\eclipse-workspace\\HackathonTest2\\Excelsheets", "Book2.xlsx", "Sheet1");
			mobileNumber = data[1][0].toString();
			password = data[1][1].toString();
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getPassword() {
		return password;
		
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}

}
