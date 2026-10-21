class Solution {
    public int minOperations(String s) {
        int i, n = s.length();
        int sidx = 0, gidx = 0;
        char schar = s.charAt(0), gchar = s.charAt(0);
        int cut = 0;
        for(i=1; i<n; i++){
            char ch = s.charAt(i);
            if(ch<schar){
                schar = ch;
                sidx = i;
            }
            else if(ch>=gchar){
                cut++;
                gchar = ch;
                gidx = i;
            }
        }
        if(cut==(n-1)) return 0;
        else if(s.charAt(n-1)==schar && n==2) return -1;
        else if((s.charAt(0)==schar)|| (s.charAt(n-1)==gchar)) return 1;
        else if((s.charAt(0)==gchar) && (s.charAt(n-1)==schar)){
            int mncount=0, mxcount=0;
            for(i=0; i<n; i++){
                if(schar==s.charAt(i)) mncount++;
                else if(gchar==s.charAt(i)) mxcount++;
            }
            if(mncount>1 || mxcount>1) return 2;
            return 3;
        }
        return 2;
    }
}