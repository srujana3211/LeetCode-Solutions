class Solution {
    public String reverseParentheses(String s) {
        int i, n = s.length();
        StringBuilder ans = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        int pair[] = new int[n];
        for(i=0; i<n; i++){
            if(s.charAt(i) == '('){
                st.push(i);
            }
            else if(s.charAt(i)==')'){
                int j = st.peek();
                st.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        i = 0;
        int dir = 1;
        while(i<n && i>=0){
            if(s.charAt(i)=='(' || s.charAt(i)==')'){
                i = pair[i];
                dir = -dir;
            }
            else{
                ans.append(s.charAt(i));
            }
            i += dir;
        }
        return ans.toString();
    }
}