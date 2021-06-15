package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 줄자접기_BJ2597 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		double end = Double.parseDouble(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		double r1 = Double.parseDouble(st.nextToken());
		double r2 = Double.parseDouble(st.nextToken());
		st = new StringTokenizer(in.readLine());
		double b1 = Double.parseDouble(st.nextToken());
		double b2 = Double.parseDouble(st.nextToken());
		st = new StringTokenizer(in.readLine());
		double y1 = Double.parseDouble(st.nextToken());
		double y2 = Double.parseDouble(st.nextToken());
		
		double start = 0;
		
		double m = (r1 + r2) / 2;
		if (m >= end / 2) {
			end = m;
			b1 = b1 <= m ? b1 : m + m-b1;
			b2 = b2 <= m ? b2 : m + m-b2;
			y1 = y1 <= m ? y1 : m + m-y1;
			y2 = y2 <= m ? y2 : m + m-y2;
		} else {
			start = m;
			b1 = b1 >= m ? b1 : m + m-b1;
			b2 = b2 >= m ? b2 : m + m-b2;
			y1 = y1 >= m ? y1 : m + m-y1;
			y2 = y2 >= m ? y2 : m + m-y2;
		}
		if(b1 != b2) {
			m = (b1 + b2) / 2;
			if (m >= (end+start) / 2) {
				end = m;
				y1 = y1 <= m ? y1 : m + m-y1;
				y2 = y2 <= m ? y2 : m + m-y2;
			} else {
				start = m;
				y1 = y1 >= m ? y1 : m + m-y1;
				y2 = y2 >= m ? y2 : m + m-y2;
			}
		}
		if(y1 != y2) {
			m = (y1 + y2) / 2;
			if (m >= (end+start) / 2) end = m;
			else start = m;
		}
		
		System.out.printf("%.1f", end-start);
	}
}

