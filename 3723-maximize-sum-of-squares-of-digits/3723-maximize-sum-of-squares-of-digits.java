class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder sb = new StringBuilder();
        int n = num;
        while(sum >0){
            if(sum >=9){
                sb.append('9');
                sum -= 9;
            }
            else{
                sb.append((char)(sum+'0'));
                sum = 0;
            }
            num--;
        }
        while(num>0){
            sb.append('0');
            num--;
        }
        return (sb.length()==n)? sb.toString(): "";
    }
}