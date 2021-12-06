import java.util.Arrays;

class MissingNumber {
    public static void main(String[] args) {
        System.out.println(findMissingNumber(new int[]{4,0,3,1}));
    }

    public static int findMissingNumber(int[] nums) {
        boolean[] hash = new boolean[nums.length+1];

        for(int i=0;i<nums.length;i++) {
            hash[nums[i]] = true;
        }

        for(int i=0;i<hash.length;i++) {
            if(!hash[i])  return i;
        }
        return -1;
    }
}
