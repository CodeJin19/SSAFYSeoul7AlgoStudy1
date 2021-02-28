import java.io.*;
import java.util.*;

public class SWEA_4698 {
	
	static final int N = 1000000;
	static int[] prime = new int[N + 1];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        getPrime();
        
        for (int t = 1; t <= T; t++) {
        	st = new StringTokenizer(br.readLine());
        	String d = st.nextToken();
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	int cnt = 0;
        	for (int i = a; i <= b; i++) {
        		if (prime[i] != 0 && String.valueOf(i).contains(d))
        			cnt++;
        	}
        	
        	System.out.println("#" + t + " " + cnt);
        }
	}
	
	static void getPrime() {
		for (int i = 2; i <= N; i++) 
			prime[i] = i;
		
		for (int i = 2; i <= N; i++) {
			if (prime[i] == 0) continue;
			
			for (int j = i * 2; j <= N; j += i)
				prime[j] = 0;
		}
	}
}