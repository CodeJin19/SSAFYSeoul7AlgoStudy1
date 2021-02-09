import java.io.*;
import java.util.*;

public class BOJ_11866 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<>();
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= n; i++) q.add(i);
		
		sb.append("<");
		int cnt = 0;
		while (!q.isEmpty()) {
			// k번째가 되면 제거 후 카운트 초기화
			if (++cnt == k) {
				sb.append(q.poll()).append(", ");
				cnt = 0;
			}
			// k번째가 아니면 다시 큐에 추가
			else 
				q.add(q.poll());
		}
		sb.setLength(sb.length() - 2); // 마지막에 남아있는 ", "을 제거하기 위함
		sb.append(">");
		
		System.out.println(sb.toString());
	}
}