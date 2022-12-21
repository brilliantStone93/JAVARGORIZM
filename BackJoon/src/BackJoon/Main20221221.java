package BackJoon;

import java.util.Scanner;

public class Main20221221 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arrayLength = sc.nextInt();
		int limit = sc.nextInt();
		for(int i = 0; i < arrayLength; i++) {
			
			int num= sc.nextInt();
			if(num<limit ) System.out.print(num+" ");
			
			
		}
		
		
		
	}

}
