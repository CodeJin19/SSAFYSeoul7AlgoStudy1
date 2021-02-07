package bj1918;

// https://www.acmicpc.net/board/view/54088
// 반례

/*
 * 처음에는 괄호없는 후위 표기식 알고리즘 그대로 쓰면서 괄호 부분만 재귀로 하도록 풀었는데
 * https://jaimemin.tistory.com/828
 * 후위 표기식이 정확히 뭔가 다시 찾아보고 괄호를 우선순위 높은 연산자라고 치고 다시 만듦
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bj1918 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String string = br.readLine(); // 입력받은 중위 표기식
		int size = string.length(); // 중위 표기식 문자 개수
		Stack<Character> operator = new Stack<Character>();
		StringBuilder postFix = new StringBuilder(); // 후위 표기식으로 바꾸고 여기 저장

		for (int i = 0; i <= size; i++) {

			if (i == size) {
				while (!operator.isEmpty())
					postFix.append(operator.pop());
				break;
			}

			char temp = string.charAt(i);

			switch (temp) {

			case '(':
				operator.push(temp);
				break;
			case ')':
				while (!operator.isEmpty()) {
					if (operator.peek() == '(') {
						operator.pop();
						break;
					} else
						postFix.append(operator.pop());
				}
				break;

			case '+':
			case '-':
				if (operator.isEmpty()) {
					operator.push(temp);
					break;
				}

				while (!operator.isEmpty()) {
					if (operator.peek() == '(') {
						break;
					}
					postFix.append(operator.pop());
				}
				operator.push(temp);
				break;

			case '*':
			case '/':
				if (operator.isEmpty()) {
					operator.push(temp);
					break;
				}

				while (!operator.isEmpty()) {
					if (operator.peek() == '(' || operator.peek() == '+' || operator.peek() == '-') {
						break;
					}
					postFix.append(operator.pop());
				}
				operator.push(temp);
				break;
			default:
				postFix.append(temp);
				break;
			}// switch문 끝
		} // for문 끝
		
		System.out.print(postFix);

	} // main 끝
}