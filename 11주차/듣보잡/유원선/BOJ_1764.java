import java.io.*;
import java.util.*;

public class BOJ_1764 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        List<String> ans = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
        	set.add(br.readLine());
        }
        
        int cnt = 0;
        for (int i = 0; i < m; i++) {
        	String str = br.readLine();
        	if (set.contains(str)) {
        		cnt++;
        		ans.add(str);
        	}
        }
        
        Collections.sort(ans);
        
        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append('\n');
        for (String s : ans) sb.append(s).append('\n');
        
        System.out.println(sb);
	}

}