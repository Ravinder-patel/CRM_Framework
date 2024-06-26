package Tasks;

import org.testng.annotations.Test;

public class javaProgramWithoutMainMethod {
	@Test
	public void NoOfDigits() {
		int num=10;
		int num2=num;
		int count=0;
		while(num2!=0)
		{
			num2=num2/10;
			count++;
		}
		System.out.println("No of digits in '"+num+"' is: "+count);
	}
}
