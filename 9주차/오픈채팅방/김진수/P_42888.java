package com.ssafy.algoStudy_09;

import java.util.HashMap;
import java.util.StringTokenizer;

public class P_42888 {
	public static String[] solution(String[] record) {
		HashMap<String, String> userMap = new HashMap<String, String> ();
		StringBuilder sb;
		StringTokenizer st;
		String[] answer;
		String[] uids = new String[record.length];
		String order, uid, uname;
		int idx = 0;
		boolean[] orders = new boolean[record.length];
		
		for(int i = 0; i < record.length; i++) {
			st = new StringTokenizer(record[i]);
			
			order = st.nextToken();
			uid = st.nextToken();
			
			switch(order.charAt(0)) {
			case 'E':
				uname = st.nextToken();
				uids[idx] = uid;
				orders[idx++] = true;
				userMap.put(uid, uname);
				break;
			case 'L':
				uids[idx] = uid;
				orders[idx++] = false;
				break;
			case 'C':
				uname = st.nextToken();
				userMap.put(uid, uname);
				break;
			}
		}
		
		answer = new String[idx];
		
		for(int i = 0; i < idx; i++) {
			sb = new StringBuilder();
			sb.append(userMap.get(uids[i]));
			sb.append("님이 ");
			
			if(orders[i])
				sb.append("들어왔습니다.");
			else
				sb.append("나갔습니다.");
			
			answer[i] = sb.toString();
		}
		
		return answer;
	}

	public static void main(String[] args) {
		String[] ret = solution(new String[] { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234",
				"Enter uid1234 Prodo", "Change uid4567 Ryan" });

		for (int i = 0; i < ret.length; i++)
			System.out.println(ret[i]);
	}
}
