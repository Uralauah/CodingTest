class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int total = 1;
        boolean zero = false;

        int[] ans = new int[n];

        for(int i=0;i<n;i++){
            if(nums[i] == 0){
                if(zero)
                    return ans;
                zero = true;
                continue;
            }

            total *= nums[i];
        }

        for(int i=0;i<n;i++){
            if(zero && nums[i]!=0){
                continue;
            }
            if(nums[i]==0)
                ans[i] = total;
            else
                ans[i] = total / nums[i];
        }

        return ans;
    }
}