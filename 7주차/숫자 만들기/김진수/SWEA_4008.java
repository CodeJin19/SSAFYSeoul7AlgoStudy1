package com.ssafy.algoStudy_07;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_4008 {
    static int maxVal, minVal;
 
    public static void solve(int cur, int idx, int[] list, int[] cnt) {
    	if (idx == list.length) {
            maxVal = Math.max(maxVal, cur);
            minVal = Math.min(minVal, cur);
            return;
        }
 
        for (int i = 0; i < 4; i++) {
            if (0 < cnt[i]) {
            	cnt[i]--;
                switch (i) {
                case 0:
                    solve(cur + list[idx], idx + 1, list, cnt);
                    break;
                case 1:
                    solve(cur - list[idx], idx + 1, list, cnt);
                    break;
                case 2:
                    solve(cur * list[idx], idx + 1, list, cnt);
                    break;
                case 3:
                    solve(cur / list[idx], idx + 1, list, cnt);
                    break;
                }
                cnt[i]++;
            }
        }
    }
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        StringTokenizer st;
        int cnt[];
        int list[];
        int T = Integer.parseInt(reader.readLine());
        int N;
 
        for (int itr = 1; itr <= T; itr++) {
            sb = new StringBuilder();
            minVal = Integer.MAX_VALUE;
            maxVal = Integer.MIN_VALUE;
             
            N = Integer.parseInt(reader.readLine());
            cnt = new int[4];
            list = new int[N];
 
            st = new StringTokenizer(reader.readLine());
 
            for (int i = 0; i < 4; i++)
                cnt[i] = Integer.parseInt(st.nextToken());
 
            st = new StringTokenizer(reader.readLine());
 
            for (int i = 0; i < N; i++)
                list[i] = (int) (st.nextToken().charAt(0) - '0');
 
            solve(list[0], 1, list, cnt);
 
            sb.append("#").append(itr).append(" ").append(maxVal - minVal);
            System.out.println(sb);
        }
    }
}
