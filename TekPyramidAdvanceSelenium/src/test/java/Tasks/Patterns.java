package Tasks;

import org.testng.annotations.Test;

public class Patterns {
	@Test
	public void Pattern1()
	{
		for(int i=1; i<=3; i++)
		{
			for(int j=1; j<=5-i; j++)
			{
				System.out.print(" ");
			}

			for(int k=1; k<=2*i-1; k++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("============================");
	}

	@Test
	public void Pattern2()
	{
		int size = 3;
		for (int i = 1; i <= size; i++) 
		{
			for (int j = size; j > i; j--) 
			{
				System.out.print(" ");
			}
			for (int k = 0; k < i * 2 - 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		// lower pyramid
		for (int i = 1; i <= size - 1; i++) 
		{
			for (int j = 0; j < i; j++) 
			{
				System.out.print(" ");
			}
			for (int k = (size - i) * 2 - 1; k > 0; k--) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("============================");
	}


	@Test
	public void Pattern3()
	{
		int n = 3; 

		for (int i = 1; i <= n; i++) {
			for (int j = n - i; j > 0; j--) {
				System.out.print(" ");
			}

			for (int j = 1; j <= i; j++) {
				System.out.print(j);
			}

			for (int j = i - 1; j >= 1; j--) {
				System.out.print(j);
			}

			System.out.println();
		}
		System.out.println("============================");


	}

	@Test
	public void Pattern4()
	{
		int n = 3; 
		char ch = 'A';

		for (int i = 0; i < n; i++) {

			for (int j = n - i; j > 1; j--) {
				System.out.print(" ");
			}

			for (int j = 0; j <= i; j++) {
				System.out.print((char)(ch + j));
			}

			for (int j = i - 1; j >= 0; j--) {
				System.out.print((char)(ch + j));
			}

			System.out.println();
		}
		System.out.println("============================");

	}



	@Test
	public void Pattern5()
	{
		int size = 3;

		for (int i = 1; i <= size; i++) {

			for (int j = size; j > i; j--) {
				System.out.print(" ");
			}

			for (int k = 0; k < i * 2 - 1; k++) {
				if (k == 0 || k == 2 * i - 2) {
					System.out.print("1");
				}
				else {
					System.out.print("*");
				}
			}
			System.out.println();
		}


		for (int i = 1; i < size; i++) {

			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}

			for (int k = (size - i) * 2 - 1; k >= 1; k--) {
				if (k == 1 || k == (size - i) * 2 - 1) {
					System.out.print("1");
				}
				else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		System.out.println("============================");
	}


}
