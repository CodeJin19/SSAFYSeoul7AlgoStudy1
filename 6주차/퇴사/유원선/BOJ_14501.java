import java.io.*;
import java.util.*;

public class BOJ_14501 {

        public static void main(String[] args) throws NumberFormatException, IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int res = 0;
        int n = Integer.parseInt(br.readLine());
        int[][] day = new int[n + 1][2];
        int[] dp = new int[21];
        
        for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                int t = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                day[i][0] = t;
                day[i][1] = p;
        }
        
        for (int i = 1; i <= n; i++) {
                int nDay = i + day[i][0];
                if (nDay <= n + 1) dp[nDay] = Math.max(dp[nDay], dp[i] + day[i][1]);
                if (i + 1 <= n + 1) dp[i + 1] = Math.max(dp[i + 1], dp[i]);
                        
                res = Math.max(Math.max(res, dp[nDay]), dp[i + 1]);
        }
        
        System.out.println(res);
        }
}