package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders 
{
	//Data provider 1
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
	String path="C:\\Users\\raviv\\OneDrive\\Desktop\\Java\\OpenCart_July2023\\testData\\Opencart_LoginData.xlsx";
	ExcelUtility eu=new ExcelUtility(path);
	
	
	int totalrows=eu.getRowCount("sheet1");
	int totalcols=eu.getCellCount("sheet1", 1);
	
	String logindata[][]=new String[totalrows][totalcols];
	
	for(int i=1;i<=totalrows;i++)
	{
		for(int j=0;j<totalcols;j++)
		{
			logindata[i-1][j]=eu.getCellData("sheet1", i, j);
		}
	}
	
	
	
	return logindata;
	}
	
	// data provider 2
}
