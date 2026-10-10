class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int i, n = nums1.length;
        int max = 0;
        int diff[] = new int[100001];
        long k = (long)k1+k2;
        long sum = 0;
        for (i = 0; i < nums1.length; i++) {
            int x = Math.abs(nums1[i] - nums2[i]);
            diff[x]++;
            sum += x;
            max = Math.max(max, x);
        }
        if(sum<=k) return 0;
        for(i = max; i > 0 && k > 0; i--) {
            long move = Math.min(k, diff[i]);
            diff[i] -= move;
            diff[i - 1] += move;
            k -= move;
        }
        long ans = 0;
        for (i = 0; i <= max; i++)
            ans += (long) i * i * diff[i];

        return ans;
    }
}