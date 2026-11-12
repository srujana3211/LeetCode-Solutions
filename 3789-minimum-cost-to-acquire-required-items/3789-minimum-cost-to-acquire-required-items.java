class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long ans = 0;
        if((cost1+cost2)>costBoth){
            int min = Math.min(need1, need2);
            ans += 1L*min*costBoth;
            need1 -= min;
            need2 -= min;
        }
        if(need1>0 && costBoth<cost1){
            ans += 1L*need1*costBoth;
            need1 = 0;
        }
        if(need2>0 && costBoth<cost2){
            ans += 1L*need2*costBoth;
            need2 = 0;
        }
        ans += 1L*need1*cost1;
        ans += 1L*need2*cost2;
        return ans;
    }
}