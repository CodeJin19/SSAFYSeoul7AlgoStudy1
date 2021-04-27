import java.util.*;

class Solution {
    
    static int answer = 0;
    static List<HashSet<String>> list = new ArrayList<>();
    static HashSet<String> set;
    
    public int solution(String[] user_id, String[] banned_id) {
        List<String> tmp = new ArrayList<>();
        DFS(0, tmp, user_id, banned_id);
         
        return answer;
    }
    
    static void DFS(int start, List<String> tmp, String[] user_id, String[] banned_id) {
        if (tmp.size() == banned_id.length) {
            HashSet<String> tmpSet = new HashSet<>(tmp);
        
            if (!list.contains(tmpSet)) {
                list.add(tmpSet);
                answer++;
            }      
            return;
        }
        
        for (int i = start; i < banned_id.length; i++) {
            for (int j = 0; j < user_id.length; j++) {
                if (tmp.contains(user_id[j])) 
                    continue;
                
                if (isRightBanned(user_id[j], banned_id[i])) {
                    tmp.add(user_id[j]);
                    DFS(i + 1, tmp, user_id, banned_id);
                    tmp.remove(user_id[j]);
                }
            }
        }
    }
    
    static boolean isRightBanned(String user, String banned) {
        if (user.length() != banned.length()) 
            return false;
        else {
            for (int i = 0; i < user.length(); i++) {
                if (user.charAt(i) != banned.charAt(i) && banned.charAt(i) != '*')
                    return false;
            }
            return true;
        }
    }
}