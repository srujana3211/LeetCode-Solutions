class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        int i, n =s.length();
        StringBuilder sb = new StringBuilder();
        Map<String, String> map = new HashMap<>();
        for(i=0; i<knowledge.size(); i++){
            map.put(knowledge.get(i).get(0), knowledge.get(i).get(1));
        }
        for(i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                int j = i+1;
                while(s.charAt(j)!=')'){
                    j++;
                }
                String key = s.substring(i+1, j);
                if(map.containsKey(key)) sb.append(map.get(key));
                else sb.append('?');
                i = j;
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}