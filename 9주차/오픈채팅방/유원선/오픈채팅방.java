import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer;
        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < record.length; i++) {
            String[] log = record[i].split(" ");
            if (log[0].equals("Enter")) {
                map.put(log[1], log[2]);
                list.add("E"+log[1]);
            }
            else if (log[0].equals("Leave")) {
                list.add("L"+log[1]);
            }
            else {
                map.put(log[1], log[2]);
            }
        }
        
        answer = new String[list.size()];
        int idx = 0;
        for (String s : list) {
            String msg = "";
            if (s.charAt(0) == 'E') 
                msg = map.get(s.substring(1)) + "님이 들어왔습니다.";
            else 
                msg = map.get(s.substring(1)) + "님이 나갔습니다.";
            
            answer[idx++] = msg;
        }
        
        return answer;
    }

}