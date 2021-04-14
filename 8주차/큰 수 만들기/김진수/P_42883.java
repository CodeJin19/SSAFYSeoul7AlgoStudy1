package com.ssafy.algoStudy_08;

public class P_42883 {
	public static String solution(String number, int k) {
		String answer = "";
		int max, idx = 0;
		int start = 0;
		int len = number.length();

		while (0 < k) {
			if(k == len - start) {
				start = len;
				break;
			}	
			
			max = '0';

			for (int i = 0; i < k + 1; i++) {
				if (max < number.charAt(start + i)) {
					max = number.charAt(start + i);
					idx = i;
				}
			}

			k -= idx;
			start += idx;
			answer += number.charAt(start);
			start++;
		}

		for (int i = start; i < len; i++)
			answer += number.charAt(i);

		return answer;
	}

	/*
	public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
		int max, idx = 0;
		int start = 0;
		int len = number.length();

		while (0 < k) {
			if(k == len - start) {
				start = len;
				break;
            }	
            
            if(number.charAt(start) == '9') {
                answer.append(number.charAt(start++));
            } else {
                max = '0';

    			for (int i = 0; i < k + 1; i++) {
	    			if (max < number.charAt(start + i)) {
			    		max = number.charAt(start + i);
		    			idx = i;
	    			}
    			}

			    k -= idx;
		    	start += idx;
	    		answer.append(number.charAt(start++));
            }
		}

		for (int i = start; i < len; i++)
			answer.append(number.charAt(i));

		return answer.toString();
	}*/

	public static void main(String[] args) {
		String tmp = solution("999", 2);

		System.out.println("answer : " + tmp);
	}
}
