class Solution {
    public void helper(Map<Integer, Integer> map){
        map.put(1, 31);
        map.put(2, 28);
        map.put(3, 31);
        map.put(4, 30);
        map.put(5, 31);
        map.put(6, 30);
        map.put(7, 31);
        map.put(8, 31);
        map.put(9, 30);
        map.put(10, 31);
        map.put(11, 30);
        map.put(12, 31);
        return;
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        Map<Integer, Integer> map = new HashMap<>();
        helper(map);
        int aam = Integer.valueOf(arriveAlice.substring(0, 2));
        int aad = Integer.valueOf(arriveAlice.substring(3, 5));
        int bam = Integer.valueOf(arriveBob.substring(0, 2));
        int bad = Integer.valueOf(arriveBob.substring(3, 5));
        int alm = Integer.valueOf(leaveAlice.substring(0, 2));
        int ald = Integer.valueOf(leaveAlice.substring(3, 5));
        int blm = Integer.valueOf(leaveBob.substring(0, 2));
        int bld = Integer.valueOf(leaveBob.substring(3, 5));
        if(alm<bam || (alm==bam && ald<bad)) return 0;
        if(blm<aam || (blm==aam && bld<aad)) return 0;
        int i, ans = 0;
        int am = Math.max(aam, bam);
        int ad = (aam>bam)? aad: (bam>aam)? bad: Math.max(aad, bad);
        int lm = Math.min(alm, blm);
        int ld = (alm<blm)? ald: (blm<alm)? bld: Math.min(ald, bld);
        System.out.println(am);
        System.out.println(ad);
        System.out.println(lm);
        System.out.println(ld);
        if(am==lm) return ld-ad+1;
        for(i = am+1; i<lm; i++){
            ans += map.get(i);
        }
        ans += map.get(am)-ad+1;
        ans += ld;
        return ans;
    }
}