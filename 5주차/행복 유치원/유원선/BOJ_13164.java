import java.io.*;
import java.util.*;

public class BOJ_13164 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st = new StringTokenizer(br.readLine());
                
                int n = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                int tmp = 0, sum = 0;
                int[] diff = new int[n - 1]; // 붙어있는 유치원생의 키 차이를 저장하는 배열
               
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                	int height = Integer.parseInt(st.nextToken());
                	if (i > 0) 
                		diff[i - 1] = height - tmp;
                	
                	tmp = height;
                }
                
                Arrays.sort(diff); // 키 차이가 작은 원생들부터 묶기 위해 오름차순 정렬
                
                // (n - k)번 만큼 키 차이 값을 더해감
                for (int i = 0; i < n-k; i++) sum += diff[i]; 
                System.out.println(sum);
	}

}
