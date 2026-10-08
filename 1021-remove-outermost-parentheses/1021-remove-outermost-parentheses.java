class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length(), i;
        int arr[] = new int[n];
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack();
        for(i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(i);
            }
            else{
                int temp = st.pop();
                if(st.isEmpty()){
                    arr[temp] = 1;
                    arr[i] = 1;
                }
            }
        }
        for(i=0; i<n; i++){
            if(arr[i]==0){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}