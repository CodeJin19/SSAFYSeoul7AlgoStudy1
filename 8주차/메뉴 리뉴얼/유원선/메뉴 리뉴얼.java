import java.util.*;

class Solution {
    
    static int[] selected;
    static Map<String, Integer> map;
    
    public String[] solution(String[] orders, int[] course) {
        int idx = 0;
        List<String> answerList = new ArrayList<>();
        
        for (int i = 0; i < course.length; i++) {
            selected = new int[course[i]];
            map = new HashMap<>();
            
            for (int j = 0; j < orders.length; j++) {
                if (orders[j].length() >= course[i]) {
                    // 미리 정렬하기
                    char[] tmpArr = orders[j].toCharArray();
                    Arrays.sort(tmpArr);
                    orders[j] = String.valueOf(tmpArr);
                    
                    combi(0, 0, orders[j], course[i]);
                }
            }
            
            // course의 길이가 모든 orders에 있는 길이보다 클 때 
            if (map.size() == 0) continue; 
            
            // 가장 빈도 수가 많은 순으로 정렬하기 위해 Map을 list로 변경하는 작업
            List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, (m1, m2) -> m2.getValue() - m1.getValue());
                    
            int max = list.get(0).getValue();
            
            for (Map.Entry<String, Integer> m : list) {
                int curVal = m.getValue();
                
                // 최댓값과 수가 같고, 최소 2번 이상 주문되면 result에 추가
                if (max == curVal && curVal >= 2) 
                    answerList.add(m.getKey());
            }
        }
        
        // 오름차순 정렬
        Collections.sort(answerList);
        
        String[] answer = new String[answerList.size()];
        for (String s : answerList) 
            answer[idx++] = s;
        
        return answer;
    }
    
    static void combi(int idx, int start, String order, int limit) {
        if (idx == limit) {
            String str = "";
            for (int i = 0; i < limit; i++) 
                str += order.charAt(selected[i]);
            
            if (map.containsKey(str)) map.put(str, map.get(str) + 1);
            else map.put(str, 1);
            
            return;
        }
        
        
        for (int i = start; i < order.length(); i++) {
            selected[idx] = i;
            combi(idx + 1, i + 1, order, limit);
        }
    }
}