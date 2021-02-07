package bj1935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bj1935 {
	
	/*
	 * 
	 * int inputNum[]에 입력받은 피연산자가 들어옴
	 *  1   2   3   4
	 * [0] [1] [2] [3]
	 * 
	 * String string = "ABC*+AE/-" 이런 식이 들어왔을 때
	 * 'A' - 'A' = 0이므로 A -> inputNum[0] = 1
	 * 'B' - 'A' = 1이므로 B -> inputNum[1] = 2
	 * 'C' - 'A' = 2이므로 C -> inputNum[2] = 3
	 *  
	 */
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());
		
		String string = br.readLine();
		int inputNum[] = new int[size];
		
		for (int i = 0; i < inputNum.length; i++) {
			inputNum[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Double> stack = new Stack<Double>();
		
		for (int i = 0; i < string.length(); i++) {
			char temp = string.charAt(i);
			
			double num1;
			double num2;
			
			switch(temp) {
			case '+':
				num2 = stack.pop();
				num1 = stack.pop();
				stack.push(num1+num2);
				break;
			case '-':
				num2 = stack.pop();
				num1 = stack.pop();
				stack.push(num1-num2);
				break;
			case '*':
				num2 = stack.pop();
				num1 = stack.pop();
				stack.push(num1*num2);
				break;
			case '/':
				num2 = stack.pop();
				num1 = stack.pop();
				stack.push(num1/num2);
				break;
			default:
				int num = temp - 'A';
				stack.push((double)inputNum[num]);
				break;
			}
		}
		System.out.printf("%.2f", stack.pop());
	}
}
