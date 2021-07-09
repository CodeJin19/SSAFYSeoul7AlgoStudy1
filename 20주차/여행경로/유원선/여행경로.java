import java.util.*;

class Solution {
    
    static int len;
    static boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length+1];
        len = tickets.length + 1;
        
        Arrays.sort(tickets, (t1, t2) -> t1[1].compareTo(t2[1]));
        visited = new boolean[tickets.length];
    
        DFS("ICN", 0, tickets, answer);
            
        return answer;
    }
    
    static boolean DFS(String from, int cnt, String[][] tickets, String[] answer) {
        answer[cnt] = from;

        if (cnt == len-1) {
            return true;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (from.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                boolean flag = DFS(tickets[i][1], cnt+1, tickets, answer);
                if (flag) {
                    return true;
                }
                visited[i] = false;
            }
        }
        
        return false;
    }
    
}