import java.io.*;
import java.util.*;

public class BOJ_9613 {

	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
        	st = new StringTokenizer(br.readLine());
        	n = Integer.parseInt(st.nextToken());
            int[] numbers = new int[n];
        	for (int j = 0; j < n; j++) {
        		numbers[j] = Integer.parseInt(st.nextToken());
        	}
        	
        	int[] flag = new int[n];
        	int cnt = 0;
        	while(++cnt <= 2) flag[n - cnt] = 1;
        	
        	long sum = 0;
        	do {
        		int first = -1, second = -1;
        		for (int j = 0; j < n; j++) {
        			if (flag[j] == 1) {
        				if (first == -1) first = numbers[j];
        				else second = numbers[j];
        			}
        		}
        		sum += GCD(first, second);
        	} while (np(flag));
        	
        	System.out.println(sum);
        }
	}
	
	static boolean np(int[] arr) {
		int i = n - 1;
		while (i > 0 && arr[i - 1] >= arr[i]) --i;
		
		if (i == 0) return false;
		
		int j = n - 1;
		while (arr[i - 1] >= arr[j]) --j;
		
		swap(i - 1, j, arr);
		Arrays.sort(arr, i, n);
		
		return true;
	}
	
	static void swap(int i, int j, int[] arr) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	static int GCD(int a, int b) {
		if (b == 0) return a;
		else return GCD(b, a % b);
	}
}