import java.io.*;
import java.util.*;

public class BOJ_14503 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        int[][] board = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        while (true) {
            // 아직 청소하지 않았으면 2로 갱신하고 카운트
            if (board[x][y] != 2) {
                board[x][y] = 2; // 현재 위치 청소(청소한 상태 : 2)
                cnt++;
            }

            boolean cleaning = false;

            int tmpDir = dir;
            // 다시 원래 방향으로 돌아올 때까지 탐색
            do {
                tmpDir = (tmpDir + 3) % 4; // 방향 회전

                int nx = x + dx[tmpDir];
                int ny = y + dy[tmpDir];

                // 청소할 공간이 없다면 방향만 회전
                if (board[nx][ny] != 0)
                    continue;

                // 청소하지 않은 공간이면 회전 후 1칸 전진
                if (board[nx][ny] == 0) {
                    cleaning = true;
                    dir = tmpDir;
                    x = nx;
                    y = ny;
                    break;
                }
            } while(tmpDir != dir);

            // 네 방향 모두 청소가 되어있거나 벽이면 1칸 후진. 후진할 곳이 벽이면 작동 중지
            if (!cleaning){
                int backDir = (dir + 2) % 4; // 후진할 방향
                int nx = x + dx[backDir];
                int ny = y + dy[backDir];

                // 벽이면 중지
                if (board[nx][ny] == 1)
                    break;

                // 1칸 후진
                x = nx;
                y = ny;
            }
        }

        System.out.println(cnt);
    }
}