package nowcoder.ctci;

import java.util.Scanner;

public class Reverse_2 {
	
	 public String reverseString(String iniString) {
		 char[] string = iniString.toCharArray();
		 
		 int left = 0;
		 int right = string.length - 1;
		 while( left < right){
			 char tmp = string[left];
			 string[left] = string[right];
			 string[right] = tmp;
			 
			 left++;
			 right--;
		 }
		 
		 
		 return new String(string);
	 }
	 

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Reverse_2 reverse = new Reverse_2();
		
		
		while( scan.hasNext() ){
			String iniString = scan.nextLine();
			String reverseStr = reverse.reverseString(iniString);
			System.out.println(reverseStr);
			
		}
		
	}

}
