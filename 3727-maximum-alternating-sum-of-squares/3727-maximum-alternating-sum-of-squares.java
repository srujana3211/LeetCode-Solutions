class Solution {
    private final Random random = new Random();
    public void swap(long[] a, int i, int j) {
        long t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public void select(long sq[], int k){
        int l =0, h = sq.length-1;
        while(l<h){
            int t = random.nextInt(h-l+1);
            System.out.println(t);
            long pivot = sq[l+t];
            int i = l, pts = l, ptl = h;
            while(i<=ptl){
                if(sq[i]<pivot) swap(sq, i++, pts++);
                else if(sq[i]>pivot) swap(sq, i, ptl--);
                else i++;
            }
            if(k<pts) h = pts-1;
            else if(k>ptl+1) l = ptl+1;
            else return;
        }
    }
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length, k = n/2;
        int i;
        long[] sq = new long[n];
        long total = 0;
        for(i=0; i<n; i++){
            sq[i] = (long)(nums[i]*nums[i]);
            total += sq[i];
        }
        select(sq, k);
        long small = 0;
        for(i=0; i<k; i++){
            small += sq[i];
        }
        return total - 2*small;
    }
}