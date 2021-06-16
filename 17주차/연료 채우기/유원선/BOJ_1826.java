package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_1826 {
	
	static class Station {
		int dis, fuel;
		
		Station (int dis, int fuel) {
			this.dis = dis;
			this.fuel = fuel;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
//		PriorityQueue<Station> station1 = new PriorityQueue<>((s1, s2) -> s1.dis - s2.dis);
		PriorityQueue<Station> station1 = new PriorityQueue<>(new Comparator<Station>() {
			@Override
			public int compare(Station o1, Station o2) {
				return o1.dis - o2.dis;
			}
		});
//		PriorityQueue<Station> station2 = new PriorityQueue<>((s1, s2) -> s2.fuel - s1.fuel);
		PriorityQueue<Station> station2 = new PriorityQueue<>(new Comparator<Station>() {
			@Override
			public int compare(Station o1, Station o2) {
				return o2.fuel - o1.fuel;
			}
		});
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			station1.add(new Station(a, b));
		}
		
		st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int cur = P, cnt = 0;
		boolean flag = true;
		
		while (cur < L) {
			while (!station1.isEmpty() && station1.peek().dis <= cur) {
				station2.add(station1.poll());
			}
			
			if (station2.isEmpty()) {
				flag = false;
				break;
			}
			
			cur += station2.poll().fuel;
			cnt++;
		}
		
		if (!flag) System.out.println(-1);
		else System.out.println(cnt);
	}

}
