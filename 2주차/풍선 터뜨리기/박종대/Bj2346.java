package bj2346;

/*
 * 풀어볼만한 반례
 * <입력>
 * 5
 * -5 -5 -5 -5 -5
 * 
 * <출력>
 * 1 5 3 2 4
 * 
 * 
 * 왼쪽으로 이동은
 * index = (list.size() + ((index + move) % list.size())) % list.size();
 *                        <            ㄱ              >
 *         <                     ㄴ                     >
 *         <                           ㄷ                             > 
 *         
 * 현재 index = 0,  move = -5일 때
 * 
 * ㄱ. (0 -5) = -5,    왼쪽으로 5번 이동인데 리스트 크기만큼 나머지 연산하면 -5%5 = -1 왼쪽으로 한번 이동과 동일
 * ㄴ. 인덱스 -1을 리스트의 가장 마지막 인덱스로 바꾸는 과정, 파이썬에서 음수 인덱스 쓰는 그런 느낌
 * ㄷ. 리스트 크기를 벗어나지 않도록 다시 나머지 연산
 * 
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Bj2346 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		List<int[]> list = new ArrayList<int[]>();
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < num; i++) {
			int input = Integer.parseInt(st.nextToken());
			list.add(new int[] {i+1, input});
		}
		
		StringBuilder sb = new StringBuilder();
		int index = 0;
		
		int move = list.get(index)[1];
		
		sb.append(list.get(index)[0]);
		
		for (int i = 0; i < num-1; i++) {
			list.remove(index);
			if (move > 0)
				index = (index + move + list.size() -1) % list.size();
			else
				index = (list.size() + ((index + move) % list.size())) % list.size();
					
			move = list.get(index)[1];
			
			sb.append(" ");
			sb.append(list.get(index)[0]);
			
		}
		
		System.out.println(sb);
	}
}