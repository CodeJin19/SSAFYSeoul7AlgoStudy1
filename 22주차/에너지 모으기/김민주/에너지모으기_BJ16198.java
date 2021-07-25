package week22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 에너지모으기_BJ16198 {

	static int N, max = 0;
	static int [] weights;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		weights = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i<N; i++) {
			weights[i] = Integer.parseInt(st.nextToken());
		}
		calc(N, 0);
		System.out.println(max);
	}
	
	public static void calc(int n, int energy) {
		if(n == 2) {
			max = Math.max(max, energy);
			return;
		}
		
		for(int i = 1; i<N-1; i++) {
			if(weights[i] == 0) continue;
			
			int val = weights[i];
			weights[i] = 0;
			
			int w1 = 0, w2 = 0;
			for(int left = i-1; left>=0; left--) {
				if(weights[left] == 0) continue;
				else {
					w1 = weights[left];
					break;
				}
			}
			
			for(int right = i+1; right<=N-1; right++) {
				if(weights[right] == 0) continue;
				else {
					w2 = weights[right];
					break;
				}
			}
			int e = w1*w2;
			calc(n-1, energy+e);
			weights[i] = val;
		}
	}
}
