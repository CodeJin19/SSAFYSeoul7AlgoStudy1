package com.ssafy.baekjoon;

import java.io.*;
import java.util.*;

public class 회의실배정_BJ1931 {

	static class Time implements Comparable<Time>{
		int start, end;

		public Time(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Time o) {
			if(this.end == o.end) {
				return this.start-o.start;
			}
			return this.end-o.end;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Time [] time = new Time[N];

		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			time[i] = new Time(start, end);
		}
		Arrays.sort(time);
		int cnt = 1;
		int end = time[0].end;
		for(int i = 1; i<N; i++) {
			if(end <= time[i].start) {
				cnt++;
				end = time[i].end;
			}
			
		}
		System.out.println(cnt);
	}
}
