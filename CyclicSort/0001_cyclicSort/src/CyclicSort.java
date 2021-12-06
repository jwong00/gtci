import java.util.Arrays;

class CyclicSort {

    public static void main(String[] args) {
        int[] t = new int[]{3,1,5,4,2};
        sort(t);
        System.out.println(Arrays.toString(t));
    }
    public static void sort(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            while(nums[i] != i+1) {
                int k = nums[i];
                nums[i] = nums[nums[i]-1];
                nums[k-1] = k;
            }
        }
    }
}
