package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Contact_BJ1013 {
	public static void main (String[] args) throws java.lang.Exception {
	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    int T = Integer.parseInt(in.readLine());
	    for(int t=0;t<T;t++){
	        String str = in.readLine().trim();
	        String ptn="(100+1+|01)+";
	        System.out.println(str.matches(ptn)? "YES" : "NO");
	    }
	}
}
