package week23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나무재테크_BJ16235 {

	static int N, M, K;
	static int [][] A;
	static int [][] nutrient;
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    
	static class Tree implements Comparable<Tree>{
		int r, c, num, age;

		public Tree(int r, int c, int age, int num ) {
			super();
			this.r = r;
			this.c = c;
			this.age = age;
			this.num = num;
		}

		@Override
		public int compareTo(Tree o) {
//			if(this.r == o.r && this.c == o.c) 
				return this.age-o.age;
//			return 0;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int [N+1][N+1]; //겨울에 추가되는 양분
		nutrient = new int [N+1][N+1];
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 1; j<=N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				nutrient[i][j] = 5;
			}
		}
		Queue<Tree> tree = new LinkedList<>();
		PriorityQueue<Tree> live = new PriorityQueue<>();
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			live.add(new Tree(r, c, age, 1));
		}
		
		for(int k = 0; k<K; k++) {
			//봄
			int size = live.size();
			for(int i = 0; i<size; i++) {
				Tree tr = live.poll();
				int r = tr.r;
				int c = tr.c;
				int age = tr.age;
				int num = tr.num;
				if(nutrient[r][c] >= age) {
					nutrient[r][c]-=age; //자신의 나이만큼 양분을 먹고
					++age; // 나이가 1 증가한다
				}
				else num = -1; //양분이 부족하면 즉사
				tree.add(new Tree(r,c,age,num));
				
			}
//			System.out.println(tree.size());
			//여름
			size = tree.size();
			for(int i = 0; i<size; i++) {
				Tree tr = tree.poll();
				if(tr.num == -1) {//죽은 나무가 양분으로 변함
					int age = tr.age/2;
					nutrient[tr.r][tr.c] += age;
					
				}
				else tree.add(tr);
			}

			//가을
			size = tree.size();
			for(int i = 0; i<size; i++) {
				Tree tr = tree.poll();
				int r = tr.r;
				int c = tr.c;
				int age = tr.age;
				if(age%5==0) {//나이가 5의 배수면 번식
					for(int d = 0; d<8; d++) {
						int di = r + dx[d];
						int dj = c + dy[d];
						if(di > 0 && dj > 0 && di <= N && dj <= N) {
							live.add(new Tree(di, dj, 1, 1)); //나이가 1인 나무가 생긴다
						}
					}
				}
				live.add(tr);
			}
			//겨울
			for(int i = 1; i<=N; i++) {
				for(int j = 1; j<=N; j++) {
					nutrient[i][j] += A[i][j]; // 땅에 양분 추가된다
				}
			}
		}
//		int cnt = 0;
//		while(!tree.isEmpty()) {
//			Tree tr = tree.poll();
//			if(tr.num != -1) cnt++;
//		}
		System.out.println(live.size());
		
	}
	
}
