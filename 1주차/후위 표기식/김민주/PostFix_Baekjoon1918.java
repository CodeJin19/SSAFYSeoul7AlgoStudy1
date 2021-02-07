package com.ssafy.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostFix_Baekjoon1918 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine(); //처음 식 저장하는 문자열
		Stack<Character> stack = new Stack<Character>(); // 연산자 저장 스택
		String postfix = ""; //후위표기식 문자열
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i); //간단히 쓰려고 그냥 c라는 변수에 저장

			switch (c) {
			case '(':
				stack.add(c);
				break;
			case ')':
				while (stack.peek() != '(') //열린 괄호를 만날 때까지 stack.pop을 해
					postfix += stack.pop();
				stack.pop(); //stack.peek()=='(' 이 되면 pop
				break;

			case '+':
				if (!stack.isEmpty()) { //stack이 비어있지 않다면
					while (stack.peek() != '(') { //열린 괄호르르 만날 때까지
						postfix += stack.pop(); //안에 있는거 다 빼
						if (stack.isEmpty()) //stack에 아무것도 없다면 break
							break;
					}
				}
				stack.add(c); //stack이 비어있다면 바로 추가
				break;

			case '-':
				if (!stack.isEmpty()) {
					while (stack.peek() != '(') {
						postfix += stack.pop();
						if (stack.isEmpty())
							break;
					}
				}
				stack.add(c);
				break;

			case '*':
				if (!stack.isEmpty()) {
					while (stack.peek() == '*' || stack.peek() == '/') { //stack.peek =='*' or '/' 까지
						postfix += stack.pop(); //빼
						if (stack.isEmpty())
							break;
					}
				}
				stack.add(c); //비어있으면 바로 추가

				break;

			case '/':
				if (!stack.isEmpty()) {
					while (stack.peek() == '*' || stack.peek() == '/') {
						postfix += stack.pop();
						if (stack.isEmpty())
							break;
					}
				}
				stack.add(c);
				break;

			default:
				postfix += c;
				break;
			}

		}
		while (!stack.isEmpty())
			postfix += stack.pop();

		System.out.println(postfix);
	}
}

//if(c-'A'>= 65 && c-'A'<= 90)