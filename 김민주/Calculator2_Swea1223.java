package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Calculator2_Swea1223 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		String math = in.readLine();
		Stack<Character> character = new Stack<Character>();
		Stack<Integer> stack = new Stack<Integer>();
		String expression = "";
		//후위표기식으로 바꾸기
		for (int i = 0; i < N; i++) {
			if (math.charAt(i) != '+' && math.charAt(i) != '*') {
				expression += math.charAt(i);
			}
			else if (math.charAt(i) == '+') { 
				if (character.isEmpty()) {
					character.add(math.charAt(i));

				} else {
					while (!character.isEmpty()) {
						expression += character.pop();
					}
					character.add(math.charAt(i));
				}
			}
			else if (math.charAt(i) == '*') {
				character.add(math.charAt(i));
			}
		}
		
		while(!character.isEmpty()) expression += character.pop();

		for(int i = 0; i<expression.length(); i++) {
			if(expression.charAt(i) != '+' && expression.charAt(i) != '*')
				stack.add( expression.charAt(i)- '0');
			
			else if(expression.charAt(i) == '+') {
				stack.push(stack.pop()+stack.pop());
			}
				
			else if(expression.charAt(i)== '*') {
				stack.push(stack.pop()*stack.pop());
			}
				
		}
		System.out.println(stack.peek());
	}
}
