class Solution {
    public int[] nums1, nums2, memo;

    public int dfs(int mask){
        int idx = Integer.bitCount(mask);

        if(idx == nums1.length)
            return 0;

        if(memo[mask] != -1)
            return memo[mask];

        int result = Integer.MAX_VALUE;

        for(int i=0;i<nums2.length;i++){
            if((mask & (1<<i)) != 0)
                continue;

            int nextMask = mask | (1<<i);
            int xor = nums1[idx] ^ nums2[i];

            result = Math.min(result, xor + dfs(nextMask));
        }

        memo[mask] = result;
        return result;
    }

    public int minimumXORSum(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.memo = new int[1<<nums2.length];

        Arrays.fill(memo, -1);

        return dfs(0);
    }
}