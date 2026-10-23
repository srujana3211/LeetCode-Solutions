class Solution {
    public int sortPermutation(int[] nums) {
        int i, n = nums.length, cut = 0;
        int ans = -1;
        for(i=0; i<n; i++){
            if(nums[i]!=i){
                if (ans == -1) ans = nums[i];
                else ans &= nums[i];
            }
        }
        return (ans==-1)? 0: ans;
    }
}