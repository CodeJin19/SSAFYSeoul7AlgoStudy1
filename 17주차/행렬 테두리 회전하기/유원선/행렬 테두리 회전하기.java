import java.util.*;

class Solution {
    
    static int[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int idx = 1;
        arr = new int[rows+1][columns+1];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                arr[i][j] = idx++;
            }
        }
        
        for (int i = 0; i < queries.length; i++) {
            int minVal = rotate(queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
            answer[i] = minVal;
        }
        
        return answer;
    }
    
    static int rotate(int x1, int y1, int x2, int y2) {
        int tmp = arr[x1][y1];
        int dir = 0, min = tmp;
        int x = x1, y = y1;
        
        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if (nx < x1 || nx > x2 || ny < y1 || ny > y2) {
                nx -= dx[dir];
                ny -= dy[dir];
                dir = (dir + 1) % 4;
                nx += dx[dir];
                ny += dy[dir];
            }
            
            if (nx == x1 && ny == y1) {
                arr[x][y] = tmp;
                break;
            }
            
            min = Math.min(min, arr[nx][ny]);
            arr[x][y] = arr[nx][ny];
            
            x = nx;
            y = ny;
        }
        
        return min;
    }
}