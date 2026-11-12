class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int i, n = nums.length;
        int ans = 1;
        int countf = 1, countr = 1;
        for(i=0; i<n-1; i++){
            if(nums[i]>nums[i+1]){
                countf++;
            }
            else{
                countf = 1;
            }
            ans = Math.max(ans, countf);
        }
        for(i=0; i<n-1; i++){
            if(nums[i]<nums[i+1]){
                countr++;
            }
            else{
                countr = 1;
            }
            ans = Math.max(ans, countr);
        }
        return ans;
    }
}