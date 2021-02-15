import java.io.*;
import java.util.*;

public class BOJ_1987 {

    static int r, c, res;
    static boolean[] check = new boolean[26]; // 알파벳 방문 여부
    static char[][] board;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];
        for (int i = 0; i < r; i++)
            board[i] = br.readLine().toCharArray();

        check[board[0][0] - 65] = true;
        DFS(0, 0, 1);
        System.out.println(res);
    }

    static void DFS(int x, int y, int cnt) {
        res = Math.max(res, cnt);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= r || ny < 0 || ny >= c || check[board[nx][ny] - 65]) continue;

            check[board[nx][ny] - 65] = true;
            DFS(nx, ny, cnt + 1);
            check[board[nx][ny] - 65] = false;
        }
    }
}