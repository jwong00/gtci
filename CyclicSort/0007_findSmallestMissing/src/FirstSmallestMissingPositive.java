class FirstSmallestMissingPositive {
    public static void main(String[] args) {
        System.out.println(findNumber(new int[]{-3,1,5,4,2}));
    }
    public static int findNumber(int[] nums) {

        int i = 0;

        while(i < nums.length) {
            if(nums[i] > 0  && nums[i] < nums.length && nums[i] != nums[nums[i]-1]) swap(nums, i, nums[i]-1);
            else i++;
        }

        for(i = 0;i<nums.length;i++) {
            if(nums[i] != i+1) return i+1;
        }

        return nums.length+1;
    }

    private static void swap(int[] nums, int i, int  j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
