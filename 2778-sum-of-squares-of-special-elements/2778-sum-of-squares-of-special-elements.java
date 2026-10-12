class Solution {
    public int sumOfSquares(int[] nums) {
        int i, n = nums.length;
        long ans = 0;
        for(i=0; i<n; i++){
            if(n%(i+1)==0){
                ans += (nums[i]*nums[i]);
            }
        }
        return (int) ans;
    }
}