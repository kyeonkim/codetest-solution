import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        ArrayList<String> answerList = new ArrayList<>();
        StringTokenizer st;
        ArrayList<String> cmds = new ArrayList<>();
        ArrayList<String> ids = new ArrayList<>();
        HashMap<String, String> info = new HashMap<String, String>();
        for (int i = 0; i < record.length; i++) {
            st = new StringTokenizer(record[i]);
            String cmd = st.nextToken();
            String id = st.nextToken();
            cmds.add(cmd);
            ids.add(id);
            if (cmd.equals("Enter") || cmd.equals("Change")) {
                String nick = st.nextToken();
                info.put(id, nick);
            }
        }
        for (int i = 0; i < cmds.size(); i++) {
            if (cmds.get(i).equals("Enter")) {
                answerList.add(info.get(ids.get(i)) + "님이 들어왔습니다.");
            } else if (cmds.get(i).equals("Leave")) {
                answerList.add(info.get(ids.get(i)) + "님이 나갔습니다.");
            }
        }
        answer = answerList.toArray(new String[0]);
        return answer;
    }
}