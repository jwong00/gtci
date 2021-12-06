import java.util.*;

class AllMissingNumbers {

    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();

        boolean[] hash = new boolean[nums.length+1];

        for(int i=0;i<nums.length;i++) {
            hash[nums[i]] = true;
        }

        for(int i=1;i<hash.length;i++) {
            if(!hash[i]) missingNumbers.add(i);
        }

        return missingNumbers;
    }
}
