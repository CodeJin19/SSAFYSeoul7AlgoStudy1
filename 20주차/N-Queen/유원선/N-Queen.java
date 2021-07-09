import java.util.*;

class Solution {
    
    static int[] queen;
    static int answer = 0;
    
    public int solution(int n) {
        queen = new int[n];
       
        DFS(0, n);
        return answer;
    }
    
    static boolean isPossible(int cnt) {
        for (int i = 0; i < cnt; i++) {
            if (queen[i] == queen[cnt] || Math.abs(i - cnt) == Math.abs(queen[i] - queen[cnt])) {
                return false;
            }
        }
        
        return true;
    }
    
    static void DFS(int cnt, int n) {
        if (cnt == n) {
            answer++;
            return;
        }
        
        for (int i = 0; i < n; i++) {
            queen[cnt] = i;
            
            if (isPossible(cnt)) {
                DFS(cnt+1, n);
            }
            
        }
    }

}