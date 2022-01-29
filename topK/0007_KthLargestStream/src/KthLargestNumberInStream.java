import java.util.*;

class KthLargestNumberInStream {

    PriorityQueue<Integer> stream;

    public KthLargestNumberInStream(int[] nums, int k) {

        if(nums==null || nums.length==0) return;

        stream = new PriorityQueue<>();

        //add first k
        int i=0;
        while(i < k) {
            stream.add(nums[i++]);
        }

        //add rest, evict min element if cur > min
        while(i < nums.length && stream.size() > 0) {
            if(nums[i] > stream.peek()) {
                stream.poll();
                stream.add(nums[i]);
            }

            i++;
        }

    }

    public int add(int num) {
        if(num > stream.peek()) {
            stream.poll();
            stream.add(num);
        }
        return stream.peek();
    }

    public static void main(String[] args) {
        int[] input = new int[] { 3, 1, 5, 12, 2, 11 };
        KthLargestNumberInStream kthLargestNumber = new KthLargestNumberInStream(input, 4);
        System.out.println("4th largest number is: " + kthLargestNumber.add(6));
        System.out.println("4th largest number is: " + kthLargestNumber.add(13));
        System.out.println("4th largest number is: " + kthLargestNumber.add(4));
    }
}
