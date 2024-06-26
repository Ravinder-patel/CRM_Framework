package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderTest {
	@Test
	public void dataproviderTest(String firstname,String laststname) {
		System.out.println("firstname : "+firstname+", laststname: "+laststname);

	}
	@DataProvider
	public Object[][] getData(){
		Object[][] objArr=new Object[3][2];
		
		objArr[0][0]="ravi";
		objArr[0][1]="patel";
		
		objArr[1][0]="ram";
		objArr[1][1]="reddy";
		
		objArr[2][0]="subbu";
		objArr[2][1]="tala";
		return objArr;
		
		//create another data provider with 3 columns nd diff datatype
		
	}

}
