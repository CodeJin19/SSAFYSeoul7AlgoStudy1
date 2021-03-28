package com.ssafy.algoStudy_07;

import java.io.*;
import java.util.*;

public class SWEA_5656 {
    static int d[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
 
    public static int solve(int n, int ball, int fld[][]) {
        if (ball == n) {
            int cnt = 0;
 
            for (int i = 0; i < fld.length; i++)
                for (int j = 0; j < fld[0].length; j++)
                    if (fld[i][j] != 0)
                        cnt++;
 
            return cnt;
        }
 
        int idx, x, y, nx, ny, r;
        int ret = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<int[]>();
        int newFld[][] = new int[fld.length][fld[0].length];
 
        for (int i = 0; i < newFld[0].length; i++) {
            for (int a = 0; a < fld.length; a++)
                for (int b = 0; b < fld[0].length; b++)
                    newFld[a][b] = fld[a][b];
 
            for (int j = 0; j < newFld.length; j++) {
                if (newFld[j][i] != 0) {
                    if (1 < newFld[j][i])
                        queue.offer(new int[] { j, i, newFld[j][i] });
                    newFld[j][i] = 0;
                    break;
                }
            }
 
            while (!queue.isEmpty()) {
                y = queue.peek()[0];
                x = queue.peek()[1];
                r = queue.peek()[2] - 1;
                queue.poll();
 
                for (int j = 0; j < 4; j++) {
                    ny = y;
                    nx = x;
                    for(int k = 0; k < r; k++) {
                        ny += d[j][0];
                        nx += d[j][1];
 
                        if (0 <= ny && ny < newFld.length && 0 <= nx && nx < newFld[0].length) {
                            if (1 < newFld[ny][nx])
                                queue.offer(new int[] { ny, nx , newFld[ny][nx]});
                            newFld[ny][nx] = 0;
                        }
                    }                   
                }
            }
     
            for (int b = 0; b < newFld[0].length; b++) {
                idx = newFld.length - 1;
 
                for (int a = newFld.length - 1; 0 <= a; a--)
                    if (newFld[a][b] != 0)
                        newFld[idx--][b] = newFld[a][b];
 
                while (0 <= idx)
                    newFld[idx--][b] = 0;
            }
             
            ret = Math.min(ret, solve(n, ball + 1, newFld));
        }
 
        return ret;
    }
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        StringTokenizer st;
        int fld[][];
        int T = Integer.parseInt(reader.readLine());
        int n, w, h;
 
        for (int test_case = 1; test_case <= T; test_case++) {
            sb = new StringBuilder();
 
            st = new StringTokenizer(reader.readLine());
 
            n = st.nextToken().charAt(0) - '0';
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
 
            fld = new int[h][w];
 
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(reader.readLine());
 
                for (int j = 0; j < w; j++)
                    fld[i][j] = Integer.parseInt(st.nextToken());
            }
 
            sb.append("#").append(test_case).append(" ").append(solve(n, 0, fld));
            System.out.println(sb);
        }
    }
}
