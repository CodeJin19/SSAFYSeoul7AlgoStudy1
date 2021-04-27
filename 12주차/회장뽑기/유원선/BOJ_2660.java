import java.io.*;
import java.util.*;

public class BOJ_2660 {
	
	static final int MAX = 987654321;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
        	for (int j = 1; j <= n; j++) {
        		if (i != j) graph[i][j] = MAX;
        	}
        }
        
        for (int i = 0;; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	if (a == -1 && b== -1) break;
        	graph[a][b] = 1;
        	graph[b][a] = 1;
        }
        
        for (int k = 1; k <= n; k++) {
        	for (int i = 1; i <= n; i++) {
        		for (int j = 1; j <= n; j++) {
        			if (graph[i][k] + graph[k][j] < graph[i][j])
        				graph[i][j] = graph[i][k] + graph[k][j];
        		}
        	}
        }
        
        int min = Integer.MAX_VALUE, score = 0;
        List<Integer> ans = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
        	score = 0;
        	for (int j = 1; j <= n; j++) {
        		score = Math.max(score, graph[i][j]);
        	}
        	
        	if (score < min) {
        		ans.clear();
        		ans.add(i);
        		min = score;
        	}	
        	else if (score == min) {
        		ans.add(i);
        	}
        }
        
        Collections.sort(ans);
        
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(' ').append(ans.size()).append('\n');
        for (int i : ans) sb.append(i).append(' ');
        
        System.out.println(sb);
	}

}