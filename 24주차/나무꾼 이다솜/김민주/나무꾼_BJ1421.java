package week24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무꾼_BJ1421 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());//N개
		int C = Integer.parseInt(st.nextToken());//자를 때 C원
		int W = Integer.parseInt(st.nextToken());//나무 팔릴때 W원
		int [] tree = new int[N];
		int max = 0;
		for(int i = 0; i<N; i++) {
			tree[i] = Integer.parseInt(in.readLine());
			max = Math.max(tree[i], max);
		}
		
		long ans = 0;
		for(int i = 1; i<=max; i++) {
			long sum = 0;
			for(int n = 0; n<N; n++) {
				int cnt = tree[n] / i; 
				if(tree[n]%i == 0) --cnt;
				int cost = (tree[n]/i)*i*W - cnt*C;
				if(cost > 0) sum += cost;
			}
			ans = Math.max(sum, ans);
		}
		System.out.println(ans);
	}
}
