import java.io.*;
import java.util.*;

public class SWEA_6485 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	int[] stop = new int[5001];
        	int n = Integer.parseInt(br.readLine());
        	
        	for (int i = 0; i < n; i++) {
        		st = new StringTokenizer(br.readLine());
        		int a = Integer.parseInt(st.nextToken());
        		int b = Integer.parseInt(st.nextToken());
        		for (int j = a; j <= b; j++)
        			stop[j]++;
        	}
        	
        	int p = Integer.parseInt(br.readLine());
        	
        	StringBuilder sb = new StringBuilder();
        	sb.append('#').append(t).append(' ');
        	for (int i = 0; i < p; i++) {
        		int c = Integer.parseInt(br.readLine());
        		sb.append(stop[c]).append(' ');
        	}
        	
        	System.out.println(sb);
        }
	}
}
