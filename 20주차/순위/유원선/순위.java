import java.util.*;

class Solution {
    
    static boolean[][] player;
    static List<Integer>[] loser_list;
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        player = new boolean[n+1][n+1];
        loser_list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++)
            loser_list[i] = new ArrayList<>();
        
        for (int i = 0; i < results.length; i++) {
            player[results[i][0]][results[i][1]] = true;
            loser_list[results[i][0]].add(results[i][1]);
        }
        
        for (int i = 1; i <= n; i++) {
            for (int loser : loser_list[i]) {
                solve(i, loser);
            }
        }
        
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                if (player[i][j]) sum++;
                if (player[j][i]) sum++;
            }
            
            if (sum == n-1) answer++;
        }
        
        return answer;
    }
    
    static void solve(int winner, int loser) {
        for (int l : loser_list[loser]) {
            if (!player[winner][l]) {
                player[winner][l] = true;
                solve(winner, l);   
            }
        }
    }
}