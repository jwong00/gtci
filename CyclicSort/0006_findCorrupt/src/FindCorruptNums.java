import java.util.Arrays;

class FindCorruptNums {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findNumbers(new int[]{3,1,2,3,6,4})));
    }

    public static int[] findNumbers(int[] nums) {
        int i = 0;
        while(i<nums.length) {
            if(nums[i]!=nums[nums[i]-1]) swap(nums,i,nums[i]-1);
            else i++;
        }

        for(i=0;i<nums.length;i++) {
            if(nums[i] != i+1) {
                return new int[]{i+1,nums[i]};
            }
        }

        return new int[] { -1, -1 };
    }

    private static void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
