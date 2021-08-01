package week24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 보석상자_BJ2792 {

	static int max, N, M, ans;
	static int [] bo;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		bo = new int[M];
		for(int i = 0; i<M; i++) {
			bo[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(bo);
		max = bo[M-1];
		System.out.println(divide());
	}
	
	public static int divide() {
		int min = 1;
		
		while(min <= max) {
			int mid = ( min + max ) / 2;
			int sum = 0;

			for(int i = 0; i<M; i++) {
				if(bo[i] % mid != 0) sum += bo[i]/mid + 1;
				else sum += bo[i] / mid;
			}
			
			if(sum <= N) max = mid-1;
			else min = mid+1;
				
		}
		return min;
	}
}
