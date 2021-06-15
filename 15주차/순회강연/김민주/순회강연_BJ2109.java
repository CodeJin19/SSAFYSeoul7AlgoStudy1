package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 순회강연_BJ2109 {
/*
 * n개의 대학에서 강연 요청을 해왔다.
 * 각 대학에서는 d일 안에 와서 강연을 해주면 p만큼의 강연료를 지불하겠다고 알려옴
 * 가장 많은 돈을 벌 수 있도록 순회 강연 하려고 함
 * 하루에 회대 한 곳에서만 가능
 * 50 2
 * 10 1
 * 20 2
 * 30 1
 * 
 * 10 20 30 50
 * 1 2 1 2
 * 
 * 30+50
 * 
 * 2 5 8 10 20 50 100
 * 1 20 2 3 1 10 2
 * 
 */
	static class Lecture implements Comparable<Lecture>{ //강연료가 많은 순대로 
		int p, d;

		public Lecture(int p, int d) {
			super();
			this.p = p;
			this.d = d;
		}

		@Override
		public int compareTo(Lecture o) {
			if(o.p == this.p) 
				return o.d-this.d;
			
			return o.p-this.p;
		}
		
	}
	
	static int n;
	static Lecture[] lecture;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		lecture = new Lecture[n];
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int price = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());
			lecture[i] = new Lecture(price, day);
		}
		Arrays.sort(lecture);
		boolean [] check = new boolean[10001];
		int sum = 0;
		for(int i = 0; i<n; i++) {
			int day = lecture[i].d;
			if(check[day]) {
				for(int j = day-1; j>=1; j--) {
					if(!check[j]) {
						check[j] = true;
						sum += lecture[i].p;
						break;
					}
				}
			}
			else{
				check[day] = true;
				sum += lecture[i].p;
			}
		}
		
		System.out.println(sum);
	}
}

/*
3
1 1
10 2
10 2
*/
