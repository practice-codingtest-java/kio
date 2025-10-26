package kio.week17;

public class Solution_괄호회전하기 {
    static public int solution(String s) {
        int answer = 0;
        int len = s.length();
        s +=  s;
        int[] stack = new int[len];
        int top;
        for(int start = 0; start <len; start++){
            boolean isCorrect = true;
            top = -1;
            for(int i=start;i<start+len;i++){
                char c = s.charAt(i);
                if(c == '[' || c=='{' || c=='('){
                    stack[++top] = c;
                }
                else if (top != -1 &&
                        ((c == ')' && stack[top] == '(') ||
                                (c == ']' && stack[top] == '[') ||
                                (c == '}' && stack[top] == '{'))) {
                    top--;
                }
                else{
                    isCorrect = false;
                    break;
                }
            }
            if(top == -1 && isCorrect) answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        String s = "}]()[{";
        System.out.println(solution(s));
    }
}
