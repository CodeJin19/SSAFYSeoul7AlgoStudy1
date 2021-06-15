package com.ssafy.programmers;

import java.util.HashMap;
import java.util.Map;

public class 위장_PG42578 {

	static int count;
	public static void main(String[] args) {
		
		String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		Map<String, Integer> hm = new HashMap<>();
		for(int i = 0; i<clothes.length; i++) {	
			hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 0)+1);
		}
		int answer = 1;
		for (String str : hm.keySet()) {
			answer *= hm.get(str)+1;
		}
		System.out.println(--answer);
		
	}
	
	
	
}
