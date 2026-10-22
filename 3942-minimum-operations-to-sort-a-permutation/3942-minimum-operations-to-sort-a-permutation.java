class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length, i, z=-1;
        boolean desc = true, asc = true;
        for(i=0; i<n; i++){
            if(nums[i]==0) z=i;
            if(nums[(i+1)%n]!=(nums[i]+1)%n) asc = false;
            if (nums[(i + 1) % n] != (nums[i] - 1 + n) % n) desc = false;
        }
        if(desc==false && asc==false) return -1;
        int ans = -1, left, right;
        if(asc){
            left = z;
            right = nums[n-1]+3;
            ans = Math.min(left, right);
        }
        else{
            left = z+2;
            right = n-z;
            ans = Math.min(left, right);
        }
        return ans;
    }
}

