package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 원자소멸_Swea5648 {
	static int N, total;
	static ArrayList<Atom> atom;
	static class Atom{
		int x;
		int y;
		int d;
		int k;
		public Atom(int x, int y, int d, int k) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.k = k;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc= 1; tc<=T; tc++) {
			N = Integer.parseInt(in.readLine());
			atom = new ArrayList<Atom>();
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				atom.add(new Atom(2*(x+1000), 2*(y+1000), d, k));//0.5초 단위로 계산 하려고
//				0,2000 오른쪽
//				4000,2000 왼쪽
//				2000, 4000 아래쪽
//				2000, 0 위쪽
			}
			total = 0;
			System.out.println("#"+ tc + " " + move());
		}
	}
	
	private static int move() {
//					위, 아래, 왼쪽, 오른쪽
		int [] dx = {0, 0, -1, 1};
		int [] dy = {1, -1, 0, 0};
        int [][] map = new int[4001][4001];
		Loop: while(true) {
			
			for(int i = 0; i<atom.size(); i++) {
				Atom a = atom.get(i);
				int d = a.d;
				int k = a.k;
				a.x += dx[d];
				a.y += dy[d];
				if(a.x < 0 || a.x>4000 || a.y<0 || a.y>4000) {
					//atom.remove(i);
					//continue;
					break Loop;
				}
				map[a.x][a.y] += k;
			}
			
			for(int i = 0; i<atom.size(); i++) {
				Atom a = atom.get(i);
				if(map[a.x][a.y] != a.k) {
					total += a.k;
//                    map[a.x][a.y] =0;
				}
				else {
                    map[a.x][a.y] = 0;
                }
			}
		}
		return total;
	}
	
}

