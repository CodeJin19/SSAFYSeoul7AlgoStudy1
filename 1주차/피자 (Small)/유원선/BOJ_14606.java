import java.io.*;
import java.util.*;

public class BOJ_14606 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
		Queue<Integer> q = new LinkedList<>();
		
		int n = Integer.parseInt(in.readLine());
		
		if (n != 1) q.offer(n);
		
		int sum = 0;
		while(!q.isEmpty()) {
			int h = q.poll();
			int nh = h / 2;
			
			sum += nh * (h - nh);
			
			if (nh != 1) q.offer(nh);
			if (h - nh != 1) q.offer(h - nh);
		}
		
		System.out.println(sum);
	}
}
