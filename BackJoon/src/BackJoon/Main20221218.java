package BackJoon;

import java.util.Scanner;

public class Main20221218 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		int size = sc.nextInt();
		
		for(int i = 0; i < size; i++) {
			String date = sc.next();
			//System.out.println("FOR문 date "+date);
			int dday = Integer.parseInt(date.substring(date.indexOf("-")+1));
			//System.out.println("FOR문 dday "+dday);
			if(dday <= 90) count ++;
			
		}
		System.out.println(count);
		
	}
}
