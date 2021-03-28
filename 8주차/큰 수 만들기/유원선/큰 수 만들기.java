import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        
        for (int i = 0; i < number.length(); i++) {
            int cur = number.charAt(i) - '0';
            
            // 모두 제거했으면 스택에 넣기
            if (cnt == k) {
                stack.push(cur);
                continue;
            }
            
            // 스택이 비어있으면 삽입
            if (stack.isEmpty()) stack.push(cur);
            // 들어가려는 수가 현재 스택에 있는 top보다 작거나 같으면 삽입
            else if (stack.peek() >= cur) stack.push(cur);
            // 들어가려는 수가 더 크면 
            else {
                // 스택이 비거나 들어가려는 수보다 스택에 있는 수가 더 클 때까지 빼내기
                while (!stack.isEmpty() && stack.peek() < cur) {
                    stack.pop();
                    cnt++;
                    
                    // k개만큼 제거했으면 중단
                    if (cnt == k) break;
                }
                // 들어가려는 수 스택에 삽입
                stack.push(cur);
            }
        }
        
        // 같은 수가 연속으로 나온 경우는 빼내지 못했으므로, 남은 제거 횟수만큼 스택에서 빼내기
        for (int i = 0; i < k - cnt; i++) stack.pop();
    
        while (!stack.isEmpty()) 
            answer = String.valueOf(stack.pop()) + answer;
                
        return answer;
    }
}