import java.io.*;
import java.util.*;

public class BOJ_13410 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int max = 0;
        for (int i = 1; i <= k; i++) 
        	max = Math.max(max, swap(String.valueOf(n * i)));
        
        System.out.println(max);
	}
	
	static int swap(String str) {
		char[] arr = str.toCharArray();
		int len = str.length();
		
		for (int i = 0; i < len / 2; i++) {
			char tmp = arr[i];
			arr[i] = arr[len - i - 1];
			arr[len - i - 1] = tmp;
		}
		
		return Integer.parseInt(String.valueOf(arr));
	}
}