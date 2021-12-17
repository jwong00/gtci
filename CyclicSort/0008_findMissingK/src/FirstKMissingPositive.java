import java.util.*;

class FirstKMissingPositive {
    public static void main(String[] args) {
        System.out.println(findNumbers(new int[]{3,-1,4,5,5},3));
    }

    public static List<Integer> findNumbers(int[] nums, int k) {

        int i=0;

        while(i<nums.length) {
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i]-1])
                swap(nums,i,nums[i]-1);
            else i++;
        }

        List<Integer> missingNumbers = new ArrayList<>();
        Set<Integer> extraNumbers = new HashSet<>();
        for(i=0;i<nums.length && missingNumbers.size() < k;i++) {
            if(nums[i]!=i+1) {
                missingNumbers.add(i+1);
                extraNumbers.add(nums[i]);
            }
        }

        for(i=1;missingNumbers.size() < k;i++) {
            int candidateNumber = i+nums.length;
            if(!extraNumbers.contains(candidateNumber))
                missingNumbers.add(candidateNumber);
        }
        return missingNumbers;
    }

    private static void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
