import java.io.*;
import java.util.*;

public class BOJ_2865 {

	static class Pair {
		int id;
		float score;
		
		Pair (int id, float score) {
			this.id = id;
			this.score = score;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		boolean[] selected = new boolean[n + 1];
		List<Pair> list = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				float s = Float.parseFloat(st.nextToken());
				list.add(new Pair(num, s));
			}
		}
		
		Collections.sort(list, new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				return Float.compare(p2.score, p1.score);
			}
			
		});
		
		int cnt = 0;
		double sum = 0;
		for (Pair p : list) {
			if (!selected[p.id]) {
				sum += p.score;
				cnt++;
				selected[p.id] = true;
			}
			
			if (cnt == k) {
				System.out.println(String.format("%.1f", sum));
				break;
			}
		}
	}

}