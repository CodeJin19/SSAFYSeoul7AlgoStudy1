import java.util.*;

class Solution {
    
    static int n, res = Integer.MAX_VALUE;
    static int[][] visited;
    static Queue<Info> q = new LinkedList<>();
    
    static class Info {
        int x, y, dir, cost;
        
        Info (int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
    
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    
    public int solution(int[][] board) {
        n = board.length;
        visited = new int[n][n];
        
        visited[0][0] = -1;
        if (board[0][1] == 0) {
            q.add(new Info(0,1,1,100));
            visited[0][1] = 100;
        }
        if (board[1][0] == 0) {
            q.add(new Info(1,0,2,100));
            visited[1][0] = 100;
        }
        
        return BFS(board);
    }
    
    static int BFS(int[][] board) {
        while (!q.isEmpty()) {
            Info cur = q.poll();
            int x = cur.x, y = cur.y, dir = cur.dir;
            
            if (x == n-1 && y == n-1) 
                res = Math.min(res, cur.cost);
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int cost = (i != dir) ? cur.cost + 600 : cur.cost + 100;
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1) 
                    continue;
                
                if (visited[nx][ny] == 0 || visited[nx][ny] >= cost) {
                    q.add(new Info(nx,ny,i,cost));
                    visited[nx][ny] = cost;     
                }
            }
        }
        
        return res;
    }
    
}