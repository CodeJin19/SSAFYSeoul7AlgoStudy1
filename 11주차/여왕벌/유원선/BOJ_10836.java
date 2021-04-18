import java.io.*;
import java.util.*;

public class BOJ_10836 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] worm = new int[m][m];        
        int[] grow = new int[2*m];
        
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int zero = Integer.parseInt(st.nextToken());
        	int one = Integer.parseInt(st.nextToken());
        	int two = Integer.parseInt(st.nextToken());
        	grow[zero]++;
        	grow[zero+one]++;
        }
        
        int sum = 0, idx = 0;
        for (int i = m-1; i >= 0; i--) {
        	sum += grow[idx++];
        	worm[i][0] = sum;
        }
        
        for (int i = 1; i < m; i++) {
        	sum += grow[idx++];
        	worm[0][i] = sum;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < m; j++) {
        		if (i == 0 || j == 0)
        			sb.append(worm[i][j]+1).append(' ');
        		else
        			sb.append(worm[0][j]+1).append(' ');
        	}
        	sb.append('\n');
        }
        
        System.out.println(sb);
	}

}