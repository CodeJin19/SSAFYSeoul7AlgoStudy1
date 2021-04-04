import java.io.*;
import java.util.*;

public class BOJ_10282 {

	static int n, res, cnt;
	static int[] dis;
	static List<Info>[] graph;
	
	static class Info {
		int node, cost;
		
		Info (int node, int cost) {
			this.node = node;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			res = 0;
			cnt = 1;
			
			dis = new int[n + 1];
			Arrays.fill(dis, Integer.MAX_VALUE);
			
			graph = new ArrayList[n + 1];
			for (int i = 1; i <= n; i++)
				graph[i] = new ArrayList<>();
			
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				graph[b].add(new Info(a,s));
			}
			
			dijkstra(c);

			System.out.println(cnt + " " + res);
		}

	}
	
	static void dijkstra(int start) {
		PriorityQueue<Info> pq = new PriorityQueue<>((i1, i2) -> i1.cost - i2.cost);
		dis[start] = 0;
		pq.add(new Info(start, 0));
		
		while (!pq.isEmpty()) {
			Info cur = pq.poll();
			int curNode = cur.node, cost = cur.cost;
			
			if (res < dis[curNode]) res = dis[curNode];
			
			for (int i = 0; i < graph[curNode].size(); i++) {
				int nextNode = graph[curNode].get(i).node;
				int nextCost = graph[curNode].get(i).cost;
				
				if (dis[nextNode] > dis[curNode] + nextCost) {
					if (dis[nextNode] == Integer.MAX_VALUE) cnt++;
					
					dis[nextNode] = dis[curNode] + nextCost;
					pq.add(new Info(nextNode, dis[nextNode]));
				}
			}
		}
	}

}