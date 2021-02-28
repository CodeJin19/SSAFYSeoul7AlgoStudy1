import java.io.*;
import java.util.*;

public class SWEA_5356 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	char[][] words = new char[5][];
        	int max = 0;
        	for (int i = 0; i < 5; i++) {
        		words[i] = br.readLine().toCharArray();
        		max = Math.max(max, words[i].length);
        	}
        	
        	StringBuilder sb = new StringBuilder();
        	sb.append('#').append(t).append(' ');
        	for (int i = 0; i < max; i++) {
        		for (int j = 0; j < 5; j++) {
        			if (words[j].length > i) {
        				sb.append(words[j][i]);
        			}
        		}
        	}
        	System.out.println(sb);
        }
	}
}
