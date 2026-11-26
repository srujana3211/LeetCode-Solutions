class Solution {
    public boolean canAliceWin(int n) {
        int i = 10;
        while(i>0){
            if(i%2==0 && n<i){
                return false;
            }
            if(i%2==1 && n<i){
                return true;
            }
            n -= i;
            i--;
        }
        return false;
    }
}