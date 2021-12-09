class FirstSmallestMissingPositive {

    public static int findNumber(int[] nums) {

        int i = 0;

        while(i < nums.length) {
            if(nums[i]!=i) {
                if(nums[i] != nums[nums[i]]) swap(nums,i,nums[i]);
            }
        }

        return -1;
    }

    private static void swap(int[] nums, int i, int  j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
