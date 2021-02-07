package bj14606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int box = Integer.parseInt(in.readLine());
		
		System.out.println(pizza(box));
	}
	
	static int pizza(int box) {
		if (box == 1) {
			return 0;
		}
		int num1 = box / 2;
		int num2 = box - num1;
		
		return (num1*num2) + pizza(num1) + pizza(num2);
	}
}
