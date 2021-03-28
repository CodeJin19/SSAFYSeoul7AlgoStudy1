package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 도시분할계획_BJ1647 {

	static class City implements Comparable<City>{
		int from, to, weight;

		public City(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(City o) {
			return this.weight-o.weight;
		}
	}
	
	static int V, E;
	static int parents[];
	static City[] home;
	
	static void make() {
		for(int i = 1; i<=V; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if(parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot==bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		parents = new int[V+1];
		home = new City[E];
		for(int i = 0; i<E; i++) {
			st = new StringTokenizer(in.readLine());
		    int from = Integer.parseInt(st.nextToken());
		    int to = Integer.parseInt(st.nextToken());
		    int weight = Integer.parseInt(st.nextToken());
		    home[i] = new City(from, to, weight);
		}
		
		Arrays.sort(home);
		
		make();
		int cost = 0;
		int count = 0;//선택한 간선 수
		
		for(City city: home){
			if(union(city.from, city.to)) { //싸이클이 발생하지 않았다면
				cost += city.weight;
				if(++count == V-2) break; 
				
			}
		}
		System.out.println(cost);
	}
	
	
}




