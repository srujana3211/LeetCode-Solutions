class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i, n = nums.length;
        int ans = 0;
        int median = 0;
        if(n%2==0){
            median = (nums[n/2]+nums[n/2-1])/2;
        }
        else{
            median = nums[n/2];
        }
        for(i=0; i<n; i++){
            ans += Math.abs(nums[i]-median);
        }
        return ans;
    }
}