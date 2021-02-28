import java.io.*;
import java.util.*;

public class SWEA_4789 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	char[] person = br.readLine().toCharArray();
        	int clap = 0, newClap = 0;
        	for (int i = 0; i < person.length; i++) {
        		int num = person[i] - '0';
        		if (num == 0) continue;
        		
        		if (clap >= i) clap += num;
        		else {
        			int tmp = i - clap;
        			newClap += tmp;
        			clap += tmp + num;
        		}
        	}
        	
        	System.out.println("#" + t + " " + newClap);
        }
	}

}