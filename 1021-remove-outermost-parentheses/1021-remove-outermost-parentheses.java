class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length(), i;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                if(count>0){
                    sb.append('(');
                }
                count++;
            }
            else{
                count--;
                if(count>0){
                    sb.append(')');
                }
            }
        }
        return sb.toString();
    }
}