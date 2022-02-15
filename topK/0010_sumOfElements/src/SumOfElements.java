import java.util.*;

class SumOfElements {

    public static int findSumOfElements(int[] nums, int k1, int k2) {
        // TODO: Write your code here
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> a-b);

        for(int i=0;i<nums.length;i++) {
            heap.add(nums[i]);
        }

        for(int i=0;i<k1;i++) heap.poll();

        int sum = 0;
        for(int i=0;i<k2-k1-1;i++) {
            sum+=heap.poll();
        }
        return sum;
    }

    public static void main(String[] args) {
        int result = SumOfElements.findSumOfElements(new int[] { 1, 3, 12, 5, 15, 11 }, 3, 6);
        System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);

        result = SumOfElements.findSumOfElements(new int[] { 3, 5, 8, 7 }, 1, 4);
        System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);
    }
}
