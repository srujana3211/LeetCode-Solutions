class Solution {
    /*int[] dup=nums;
        Arrays.sort(nums, (a, b) -> {
            int suma =0,n=a;
            while(n!=0){
                suma+=n%10;
                n=n/10;
            }
            int sumb =0,nb=b;
            while(nb!=0){
                sumb+=nb%10;
                nb=nb/10;
            }
            if (suma<sumb){
                return 1;
            }
            if(suma==sumb){
                return a<b;
            }
            if (suma>sumb){
                return -1;
            }
            return Integer.compare(a, b);
        });
        int c=0,ind=0;
        for(int i=0;i<nums.length;i++){
            System.out.print(dup[i] + ",");
        }
        for(int i=0;i<nums.length;i++){
            int v=nums[i];
            // if(v!=nums[ind++]){
            //     c++;
            // }
        }
        return c/2 + c%2;*/
    public void swap(int nums[], int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
        return;
    }
    public int minSwaps(int[] nums) {
        int len = nums.length, i;
        int arr[][] = new int[len][2];
        for(i=0; i<len; i++){
            int s = 0, n = nums[i];
            while(n>0){
                s += n%10;
                n = n/10;
            }
            arr[i][0] = s;
            arr[i][1] = nums[i];
        }
        Arrays.sort(arr, (a, b)->{
            if(a[0]==b[0]){
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(i=0; i<len; i++){
            map.put(nums[i], i);
            System.out.println(arr[i][1]);
        }
        for(i=0; i<len; i++){
            int correctValue = arr[i][1];
            if (nums[i] != correctValue) {
                int j = map.get(correctValue);
                swap(nums, i, j);
                map.put(nums[j], j);
                map.put(nums[i], i);

                ans++;
            }
        }
        return ans;
    }
}