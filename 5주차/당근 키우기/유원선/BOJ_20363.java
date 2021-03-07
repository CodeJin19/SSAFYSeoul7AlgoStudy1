import java.io.*;
import java.util.*;

public class BOJ_20363 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        
        System.out.println(x + y + (Math.min(x, y) / 10));
	}

}