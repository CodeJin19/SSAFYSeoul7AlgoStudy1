package week24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 용액_BJ2467 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int [] liquid = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for(int i = 0; i<N; i++) 
			liquid[i] = Integer.parseInt(st.nextToken()); 
		
		int left = 0;
		int right = N-1;
		int min = Integer.MAX_VALUE;
		int x= 0, y = 0;
		
		while(left<right) {
			int val = Math.abs(liquid[right] + liquid[left]);
			if(min >= val){
				x = liquid[left];
				y = liquid[right];
				min = val;
			}
			if(liquid[right] + liquid[left] < 0) left++;
			else right--;
		}
		System.out.println(x + " " + y);
	}
}
