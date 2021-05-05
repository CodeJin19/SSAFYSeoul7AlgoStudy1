package com.ssafy.study;

import java.io.*;
import java.util.*;

public class BOJ_8980 {
	
	static class Info implements Comparable<Info> {
		int from, to, cnt;
		
		Info (int from, int to, int cnt) {
			this.from = from;
			this.to = to;
			this.cnt = cnt;
		}

		public int compareTo(Info i) {
			if (this.to == i.to) return this.from - i.from;
			else return this.to - i.to;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
                
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        List<Info> list = new ArrayList<>();
        int[] town = new int[n];
               
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            list.add(new Info(from,to,cnt));
        }
                
        Collections.sort(list);
                
        int res = 0;
        for (Info info : list) {
        	int min = Integer.MAX_VALUE;
            for (int i = info.from; i < info.to; i++) 
                min = Math.min(min, c - town[i]);
                	
                if (min > info.cnt) min = info.cnt;
                	
                res += min;
                	
                for (int i = info.from; i < info.to; i++)
                	town[i] += min;
        }
                
        System.out.println(res);
	}

}
