import java.util.*;

class MedianOfAStream {

    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    int sz = 0;

    public MedianOfAStream() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a,b)->b-a);
    }

    public void insertNum(int num) {
        if(max.isEmpty() || max.peek() >= num)
            max.add(num);
        else min.add(num);

        //keep heaps similarly sized
        if(max.size() > min.size() + 1)
            min.add(max.poll());
        else if(max.size() <  min.size())
            max.add(min.poll());

    }

    public double findMedian() {

        if(min.size()==max.size()) return min.poll() / 2.0 + max.poll() / 2.0;

        return max.peek();
    }

    public static void main(String[] args) {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }
}
