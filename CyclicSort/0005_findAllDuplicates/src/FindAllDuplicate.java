import java.util.*;

class FindAllDuplicate {
    public static void main(String[] args) {
        System.out.println(findNumbers(new int[]{1,4,4,3,2}));
        System.out.println(findNumbers(new int[]{3,4,4,5,5}));
        System.out.println(findNumbers(new int[]{5,4,7,2,3,5,3}));
    }

    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> duplicateNumbers = new ArrayList<>();
        int i = 0;

        while(i < nums.length) {
            if(nums[i] != nums[nums[i] - 1])
                swap(nums,i,nums[i]-1);
            else i++;
        }

        System.out.println(Arrays.toString(nums));

        for(i=0;i<nums.length;i++) {
            if(nums[i]!=i+1) duplicateNumbers.add(nums[i]);
        }
        return duplicateNumbers;
    }

    private static void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
