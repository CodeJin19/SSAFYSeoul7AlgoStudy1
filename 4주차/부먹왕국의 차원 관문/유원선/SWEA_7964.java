import java.io.*;
import java.util.*;

public class SWEA_7964 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
        	st = new StringTokenizer(br.readLine());
        	int n = Integer.parseInt(st.nextToken());
        	int d = Integer.parseInt(st.nextToken());
        	
        	st = new StringTokenizer(br.readLine());
        	int cnt = 0, sum = 0;
        	for (int i = 0; i < n; i++) {
        		int val = Integer.parseInt(st.nextToken());
        		if (val == 1) {
        			sum += cnt / d;
        			cnt = 0;
        		}
        		else
        			cnt++;
        	}
        	
        	if (cnt > 0) 
        		sum += cnt / d;
        
        	System.out.println("#" + t + " " + sum);
        }
	}
}