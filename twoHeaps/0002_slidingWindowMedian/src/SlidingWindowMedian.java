import java.util.*;

class SlidingWindowMedian {
    public double[] findSlidingWindowMedian(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        int ptr_result = 0;

        //map index to val
//        HashMap<Integer,Integer> map = new HashMap<>();

        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>((a,b)->b-a);

        for(int i=0;i<nums.length;i++) {

            //add "right-most" element
            if(max.isEmpty() || max.peek() >= nums[i])
                max.add(nums[i]);
            else min.add(nums[i]);

            //rebalance
            if(max.size() > min.size()+1)
                min.add(max.poll());
            else if(max.size() < min.size())
                max.add(min.poll());

            //slide window...
            if(i-k+1>=0) {
                //compute median
                if(max.size()==min.size()) result[i-k+1] = min.peek()/2.0 + max.peek()/2.0;
                else result[i-k+1] = max.peek();

                //then remove outgoing element
                if(nums[i-k+1] <= max.peek()) max.remove(nums[i-k+1]);
                else                        min.remove(nums[i-k+1]);


                //rebalance
                if(max.size() > min.size()+1)
                    min.add(max.poll());
                else if(max.size() < min.size())
                    max.add(min.poll());


            }
        }

        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

        slidingWindowMedian = new SlidingWindowMedian();
        result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
    }

}
