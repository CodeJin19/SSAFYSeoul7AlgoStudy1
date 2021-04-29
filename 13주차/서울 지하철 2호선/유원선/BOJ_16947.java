import java.io.*;
import java.util.*;

public class BOJ_16947 {

	static int n;
	static boolean cycle = false;
	static boolean[] visited;
	static int[] dis;
	
	static List<Integer>[] graph;
	static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        dis = new int[n+1];
        Arrays.fill(dis, -1);
        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++)
        	graph[i] = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	graph[a].add(b);
        	graph[b].add(a);
        }
        
        // 순환선 찾기
        checkCycle(1, 0);
        
        // 순환선(거리 0인 역) 큐에 넣기
        for (int i = 1; i <= n; i++) {
        	if (dis[i] == 0)
        		q.add(new int[] {i,0});
        }
        
        // 순환선으로부터의 최소 거리 구하기
        BFS();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) sb.append(dis[i]).append(' ');
        System.out.println(sb);
	}
	
	static void BFS() {
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int num = cur[0];
			
			for (int i = 0; i < graph[num].size(); i++) {
				int nextNum = graph[num].get(i);
				if (dis[nextNum] == -1) {
					dis[nextNum] = cur[1] + 1;
					q.add(new int[] {nextNum,dis[nextNum]});
				}
			}
		}
	}
	
	static void checkCycle(int num, int prevNum) {
		visited[num] = true;
		
		for (int i = 0; i < graph[num].size(); i++) {
			int nextNum = graph[num].get(i);
		
			// cycle 발생 조건
			if (nextNum != prevNum && visited[nextNum]) {
				dis[nextNum] = 0;
				cycle = true;
				break;
			}
			if (!visited[nextNum]) {
				checkCycle(nextNum, num);
				
				if (cycle) {
					// cycle 종료 조건
					if (dis[nextNum] == 0) 
						cycle = false;
					else 
						dis[nextNum] = 0;
					
					return;
				}
				
				visited[nextNum] = false;
			}
		}
	}

}