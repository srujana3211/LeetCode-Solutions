class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int i, n1 = arr1.length, n2 = arr2.length;
        Arrays.sort(arr2);
        int count = 0;
        for(i=0; i<n1; i++){
            int l = 0, h = n2-1, mid;
            boolean far = true;
            int ans = -1;
            while(l<=h){
                mid = l+(h-l)/2;
                if(arr2[mid]<=arr1[i]){
                    ans = mid;
                    l = mid+1;
                }
                else{
                    h = mid-1;
                }
            }
            if(ans!=-1 && arr2[ans]==arr1[i]){
                far = false;
            }
            else if(ans!=-1 && Math.abs(arr1[i]-arr2[ans])<=d){
                far = false;
            }
            else if(ans+1<n2 && Math.abs(arr1[i]-arr2[ans+1])<=d){
                far = false;
            }
            else if(ans!=-1 && Math.abs(arr1[i]-arr2[0])<=d){
                far = false;
            }
            if(far==true) count++;
        }
        return count;
    }
}