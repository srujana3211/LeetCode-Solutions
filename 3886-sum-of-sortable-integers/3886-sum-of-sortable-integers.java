class Solution {
    public boolean satisfy(int nums[], int k){
        int i, n = nums.length;
        int prev = 0; 
        if(k==1){
            for(i=0; i<n-1; i++){
                if(nums[i]>nums[i+1]) return false;
            }
        }
        for(i=0; i<n; i+=k){
            int j = i;
            int cut = 0;
            int min = nums[i], max = nums[i];
            while(j<(i+k-1)){
                if(nums[j]>nums[j+1]) cut++;
                min = Math.min(nums[j+1], min);
                max = Math.max(nums[j+1], max);
                j++;
            }
            if (nums[i + k - 1] > nums[i])
                cut++;
            if(cut>1) return false;
            if(prev>min) return false;
            prev = max;
        }
        return true;
    }
    public int sortableIntegers(int[] nums) {
        int i, n = nums.length;
        int ans = 0;
        for(i=1; i*i<=n; i++){
            if(n%i==0){
                if(satisfy(nums, i)){
                    ans += i;
                    System.out.println(i);
                }
                int sec = n/i;
                if(n%sec==0 && sec!=i){
                    if(satisfy(nums, n/i)){
                        ans += sec;
                        System.out.println(n/i);

                    }
                }
            }
        }
        return ans;
    }
}