package Tasks;

import org.testng.annotations.Test;

public class dualDependsOn1 {
	@Test(dependsOnMethods = "B")
	public void A() {
		System.out.println("AAAAAAAAAA");
	}

	@Test(dependsOnMethods = "A")
	public void B() {
		System.out.println("BBBBBBBBBBBB");
	}

}
