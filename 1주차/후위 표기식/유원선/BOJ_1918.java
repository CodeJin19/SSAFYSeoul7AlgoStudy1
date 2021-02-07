import java.io.*;
import java.util.*;

public class BOJ_1918 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
		
		StringBuilder sb = new StringBuilder();
		Stack<Character> s = new Stack<>();
		
		String str = in.readLine();
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			// '('은 가장 먼저 연산되어야 하므로 무조건 스택에 push	
			if (c == '(')
				s.push(c);
			else if (c == '*' || c == '/' || c == '+' || c  == '-') {
				// 스택이 비어있으면 push	
				if (s.isEmpty())
					s.push(c);
				// 스택의 top이 '('이거나 현재 연산자가 top 연산자보다 우선순위가 높다면 push
				else if (s.peek() == '(' || getPriority(c) < getPriority(s.peek()))
					s.push(c);
				// 현재 연산자가 top 연산자보다 우선순위가 낮거나 같으면
				// '('나 현재 연산자보다 낮은 우선순위의 연산자를 만날 때까지 pop	
				// pop 연산이 모두 완료되면 현재 연산자 스택에 push
				else {
					while (!s.isEmpty()) {
						char top = s.peek();
					
						if (top == '(' || getPriority(c) < getPriority(top)) 
							break;
					
						sb.append(s.pop());	
					}
					s.push(c);
				}
			}
			// '('를 만날 때까지 pop
			else if (c == ')') {
				while (!s.isEmpty()) {
					char top = s.pop();
					if (top == '(') {
						break;
					}
					sb.append(top);
				}
			}
			// 피연산자는 바로 string에 추가
			else {
				sb.append(c);
			}
		}
		
		// 스택에 남아있는 연산자 처리
		while (!s.isEmpty()) sb.append(s.pop());
		
		System.out.println(sb.toString());
	}
	
	/*
	 * 연산자의 우선순위를 반환하는 함수
	 */
	static int getPriority(char op) {
		switch(op) {
			case '*': return 1;
			case '/': return 1;
			case '+': return 2;
			case '-': return 2;
		}
		return -1;
	}
}