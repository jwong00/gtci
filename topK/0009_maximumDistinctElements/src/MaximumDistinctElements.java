import java.util.*;

class MaximumDistinctElements {

    public static int findMaximumDistinctElements(int[] nums, int k) {

        //determine frequencies
        HashMap<Integer,Integer> freq = new HashMap<>();

        for(int i=0;i<nums.length;i++) {
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
        }

        //heapify
        PriorityQueue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>();

        for(Map.Entry<Integer,Integer> e : freq.entrySet()) {
            if(e.getValue() > 1) heap.add(e);
        }

        //evict smallest numbers from heap
        while(k>0 && heap.size()>0) {
            k -= heap.poll().getValue();
        }


        return -1;
    }

    public static void main(String[] args) {
        int result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 7, 3, 5, 8, 5, 3, 3 }, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 3, 5, 12, 11, 12 }, 3);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 }, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);
    }
}
