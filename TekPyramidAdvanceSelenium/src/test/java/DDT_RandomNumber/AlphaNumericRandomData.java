package DDT_RandomNumber;

public class AlphaNumericRandomData {

	public static void main(String[] args) {
		int n=20;
		//choose a charecter randomly from this string
		String AlphaNumericString="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		
		//Create string builder size of alpha numeric 
		StringBuilder sb=new StringBuilder(n);
		
		for(int i=0;i<n;i++) 
		{
			//generate a random number between 0 to AlphaNumericVariable length
			int index=(int) (AlphaNumericString.length());	//Get the length of the string
			index=(int) (index*Math.random());	//select a random index number
			
			//add character one by one in the end of sb
			sb.append(AlphaNumericString.charAt(index));	//append() is used to add the char index value to sb one by one	
		}
		System.out.println(sb);

	}

}
