package bj11866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Bj11866 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int idx = 0;
		
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < N; i++) {
			list.add(i+1);
		}
		
		idx = (idx + K - 1) % list.size();
		
		sb.append("<");
		sb.append(list.get(idx));
		list.remove(idx);
		
		for (int i = 0; i < N-1; i++) {
			idx = (idx + K - 1) % list.size();
			sb.append(", ");
			sb.append(list.get(idx));
			list.remove(idx);
		}
		sb.append(">");
		
		System.out.println(sb);
	}
}
