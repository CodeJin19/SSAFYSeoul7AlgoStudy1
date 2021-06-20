package com.ssafy.baekjoon;

import java.io.*;
import java.util.*;

public class 행성연결_BJ16398 {
   
	static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int start, int end, int weight) {
            this.from = start;
            this.to = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
	
	static int[] parents;
    static int N;
    static List<Edge> edgeList = new ArrayList<>();
    static long answer = 0;

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
	
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                int weight = Integer.parseInt(st.nextToken());
                if (weight != 0) { // 연결 가능한 경우
                    edgeList.add(new Edge(i, j, weight));
                }
            }
        }
        Collections.sort(edgeList);

        int count = 0;
        
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            if (union(edge.from, edge.to)) { //싸이클 발생 안했으면
                answer += edge.weight;
                if(++count == N-1) break; //간선개수가 정점개수-1일때 끝
            }
        }
        System.out.println(answer);
    }

}
