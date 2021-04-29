import java.io.*;
import java.util.*;

public class BOJ_13549_2 {

	static final int MAX = 100000;
	static int n, k, res = Integer.MAX_VALUE;
	static int[] visited = new int[MAX+1];
	
	static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Arrays.fill(visited, Integer.MAX_VALUE);
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        System.out.println(BFS(n));
	}
	
	static int BFS(int start) {
		q.add(new int[] {start,0});
		visited[start] = 0;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int num = cur[0], cnt = cur[1];
				
			if (num == k)
				res = Math.min(res, cnt);
			
			for (int[] d : new int[][] {{num+1,cnt+1},{num-1,cnt+1},{num*2,cnt}}) {
				if (d[0] < 0 || d[0] > MAX || visited[d[0]] <= d[1]) continue;
			
				q.add(new int[] {d[0],d[1]});
				visited[d[0]] = d[1];				
			}
		}
		
		return res;
	}

}