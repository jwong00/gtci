import java.util.Arrays;

class FindDuplicate {
    public static void main(String[] args) {
        int[] a = {1,4,4,3,2};
        int[] b = {2,1,3,3,5,4};
        int[] c = {2,4,1,4,4};
        System.out.println(findNumber(a));
        System.out.println(findNumber(b));
        System.out.println(findNumber(c));
    }

    public static int findNumber(int[] nums) {

        int i = 0;
        while(i<nums.length) {
            if(nums[i] != i+1) {
                if(nums[i] != nums[nums[i] - 1]) swap(nums, i, nums[i] - 1);
                else return nums[i];
            }
            else i++;
        }

        return -1;
    }

    private static void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
