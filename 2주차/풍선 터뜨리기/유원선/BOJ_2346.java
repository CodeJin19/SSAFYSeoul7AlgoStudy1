import java.io.*;
import java.util.*;

public class BOJ_2346 {
	
	// 인덱스와 이동 값을 저장하는 Balloon 클래스 생성
	private static class Balloon {
		int idx, div;
		
		Balloon (int idx, int div) {
			this.idx = idx;
			this.div = div;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st;
		LinkedList<Balloon> list = new LinkedList<>();
		
		int n = Integer.parseInt(in.readLine());
		
		st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= n; i++) {
			int div = Integer.parseInt(st.nextToken());
			list.add(new Balloon(i, div));
		}
		
		StringBuilder order = new StringBuilder();
		int curDiv = 0, cur = 0;
		for (int i = 0; i < n; i++) {
			// 하나가 삭제됨에 따라, 다음 위치에 있는 인덱스들이 모두 이전 인덱스로 갱신되기 때문에 (curDiv - 1)만큼 이동
			if (curDiv > 0) {
				for (int j = 0; j < curDiv - 1; j++) {
					cur++;
					// 위치가 리스트 크기를 넘어가면 다시 0으로 할당
					if (cur >= list.size())
						cur = 0;
				}
			}
			else if (curDiv < 0) {
				curDiv *= -1;
				for (int j = 0; j < curDiv; j++) {
					cur--;
					// 위치가 0 보다 작아지면 다시 가장 큰 값으로 할당
					if (cur < 0)
						cur = list.size() - 1;
				}
			}
			
			// 리스트를 빠져나와 순서에 기록되고, 리스트에 남아있는 것 삭제
			order.append(list.get(cur).idx).append(' '); 
			curDiv = list.get(cur).div;
			list.remove(cur);
			
			// 마지막 위치에 있는 값이 제거되면서, 현재 위치가 리스트 크기와 같아지면 위치 0으로 갱신
			if (cur == list.size())
				cur = 0;
		}

		System.out.println(order.toString());
	}
}