package com.ssafy.programmers;

public class 행렬테두리_PG77485 {

	static int queries[][] = {{1,1,100,97}};
	public static void main(String[] args) {
		int N = 100, M=97;
		int map[][] = new int[N][M];
		int num = 1;
		int [] answer = new int[queries.length];
		int idx = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				map[i][j] = num++;
			}
		}
		
		int size = queries.length;
		for(int i = 0; i<size; i++) {
			int x1 = queries[i][0]-1;
			int y1 = queries[i][1]-1;
			int x2 = queries[i][2]-1;
			int y2 = queries[i][3]-1;
			int temp = map[x1][y1];
			int next = 0;
			int min = 99999;
			//윗줄 이동(왼쪽->오른쪽)
			for(int y = y1; y<y2; y++) {
				next = map[x1][y+1];
				map[x1][y+1] = temp;
				temp = next;
				min = Math.min(min, temp);
			}
			//오른쪽 이동(위->아래)
			for(int x = x1; x<x2; x++) {
				next = map[x+1][y2];
				map[x+1][y2] = temp;
				temp = next;
				min = Math.min(min, temp);
			}
			
			//아랫줄 이동(오른쪽 -> 왼쪽)
			for(int y = y2; y>y1; y--) {
				next = map[x2][y-1];
				map[x2][y-1] = temp;
				temp = next;
				min = Math.min(min, temp);
			}		
			
			//왼쪽 이동(아래->위)
			for(int x = x2; x>x1; x--) {
				next = map[x-1][y1];
				map[x-1][y1] = temp;
				temp = next;
				min = Math.min(min, temp);
			}
//			System.out.println(temp);
			answer[idx++] = min;
		}
		System.out.println(answer);
		
	}
}
