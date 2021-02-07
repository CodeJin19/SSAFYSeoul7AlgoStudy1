package com.ssafy.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostFix2_Baekjoon1935 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		String str = in.readLine();
		String [] num = new String[N];
		Stack<Double> stack = new Stack<Double>();
		String [] pf2 = new String[str.length()];
		for(int i = 0; i<N; i++) {
			num[i] = in.readLine();
		}
		for(int i = 0; i<str.length(); i++) {
			char c = str.charAt(i);
			
			if(c!='+' && c!='-' && c!='*' && c!='/')  //연산자가 아니라면 입력받은 숫자로 바꿔
				pf2[i] = num[(int)str.charAt(i)-65]; //A=>num[0], B=>num[1], C=>num[2] ...
			
			else pf2[i] = Character.toString(c); //
		}
		
		for(int i = 0; i<str.length(); i++) {
			String st = pf2[i];
			switch(st) {
			case "+":
				stack.push(stack.pop()+stack.pop());
				break;
				
			case "-":
				double a1 = stack.pop();
				double b1 = stack.pop();
				stack.push(b1-a1);
				break;
				
			case "*":
				stack.push(stack.pop()*stack.pop());
				break;
				
			case "/":
				double a2 = stack.pop();
				double b2 = stack.pop();
				stack.push(b2/a2);
				break;
				
				default:
					stack.add(Double.parseDouble(pf2[i]));
					break;
			}
		}
		System.out.printf("%.2f",stack.peek());
	}
}
