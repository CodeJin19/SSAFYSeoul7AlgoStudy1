import java.io.*;
import java.util.Stack;

public class BOJ_1935 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
		Stack<Double> s = new Stack<>();
		
		int n = Integer.parseInt(in.readLine());
		String str = in.readLine();
		
		int[] charToNum = new int[n];
		for (int i = 0; i < n; i++)
			charToNum[i] = Integer.parseInt(in.readLine());
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= 65 && c <= 90) {
				s.push((double)charToNum[c - 65]); // A의 아스키코드가 65 -> A : 0, B : 1, C : 2, ...
			}
			else {
				double second = s.pop(), first = s.pop();
				double tmp = 0;
				switch(c) {
				case '+':
					tmp = first + second;
					break;
				case '-':
					tmp = first - second;
					break;
				case '*':
					tmp = first * second;
					break;
				case '/':
					tmp = first / second;
					break;
				}
				s.push(tmp);
			}
		}
		
		System.out.printf("%.2f", s.peek());
	}
}