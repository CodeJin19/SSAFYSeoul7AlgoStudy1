import java.io.*;
import java.util.*;

public class BOJ_5430 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int i = 0; i < T; i++) {
			String lang = in.readLine();
			int n = Integer.parseInt(in.readLine());
			String tmp = in.readLine();
			String[] tmpArr = tmp.substring(1, tmp.length() - 1).split(",");
			
			LinkedList<String> list = new LinkedList<>();
			for (int j = 0; j < n; j++)
				list.add(tmpArr[j]);
	
			/*
			 * front : true - 앞에서 반환, false - 뒤에서 반환 
			 */
			boolean front = true, error = false;
			for (int j = 0; j < lang.length(); j++) {
				char c = lang.charAt(j);
				 
				if (c == 'R') front = !front;
				if (c == 'D') {
					if (list.isEmpty())  {
						System.out.println("error");
						error = true;
						break;
					}
					if (front) 
						list.pollFirst();
					else
						list.pollLast();
				}
			}
			
			if (!error) {
				sb.setLength(0);
				sb.append("[");
				if (front) {
					while (!list.isEmpty())
						sb.append(list.pollFirst()).append(",");
				}
				else {
					while (!list.isEmpty())
						sb.append(list.pollLast()).append(",");
				}
				if (sb.length() > 1) sb.setLength(sb.length() - 1);
				sb.append("]");
				
				System.out.println(sb.toString());
			}
		}
	}
}
