class Solution {
    public int minInsertions(String s) {
        Stack<Integer> st = new Stack<>();
        int i, n = s.length(), count = 0;
        for(i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch=='('){
                st.push(i);
            }
            else{
                if((i+1)!=n && s.charAt(i+1)==')' && !st.isEmpty()){
                    st.pop();
                    i++;
                }
                else if((i+1)!=n && s.charAt(i+1)==')'){
                    count++;
                    i++;
                }
                else if(!st.isEmpty()){
                    st.pop();
                    count++;
                }
                else{
                    count += 2;
                }
            }
        }
        count += st.size()*2;
        return count;
    }
}