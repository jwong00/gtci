import java.util.*;

class TopKFrequentNumbers {

    public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {

        //determine frequencies
        HashMap<Integer,Integer> frequencies = new HashMap<>();

        for(int i=0;i<nums.length;i++)
            frequencies.put(nums[i],frequencies.getOrDefault(nums[i],1)+1);

        //heapify
        PriorityQueue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());

        heap.addAll(frequencies.entrySet());

        //select k most frequent
        List<Integer> topNumbers = new ArrayList<>(k);

        while(k>0) {
            topNumbers.add(heap.poll().getKey());
            k--;
        }
        return topNumbers;
    }

    public static void main(String[] args) {
        List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);

        result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);
    }
}
