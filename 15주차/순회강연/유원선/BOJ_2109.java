package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_2109 {
	
	static int max_d, sum;
	static int[] arr;
	
	static class Univ implements Comparable<Univ> {
		int price, day;
		
		Univ (int price, int day) {
			this.price = price;
			this.day = day;
		}

		public int compareTo(Univ u) {
			if (this.price == u.price) return this.day - u.day;
			else return u.price - this.price;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		PriorityQueue<Univ> pq = new PriorityQueue<>();
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			max_d = Math.max(d, max_d);
			pq.add(new Univ(p, d));
		}
		arr = new int[max_d+1];
		
		while (!pq.isEmpty()) {
			Univ cur = pq.poll();
			int price = cur.price, day = cur.day;
			if (isPossible(day)) {
				updateArr(day);
				sum += price;
			}
		}
		
		System.out.println(sum);
	}
	
	static void updateArr(int day) {
		for (int i = day; i <= max_d; i++)
			arr[i] += 1;
	}
	
	static boolean isPossible(int day) {
		if (arr[day] == day) return false;
		for (int i = day+1; i <= max_d; i++) {
			if (arr[i] == i) return false;
		}
		
		return true;
	}

}
