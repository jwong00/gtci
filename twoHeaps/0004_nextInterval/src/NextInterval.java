import java.util.*;

class Interval {
    int start = 0;
    int end = 0;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class NextInterval {
    public static int[] findNextInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];

        PriorityQueue<Integer> min = new PriorityQueue<>((a,b)->intervals[a].start-intervals[b].start);
        PriorityQueue<Integer> max = new PriorityQueue<>((a,b)->intervals[b].end-intervals[a].end);

        for(int i=0;i<intervals.length;i++) {
            max.offer(i);
        }

        while(!max.isEmpty()) {
            int i = max.poll();
            if(min.isEmpty()) result[i] = -1;
            else if(intervals[i].end <= intervals[min.peek()].start)
                result[i] = min.peek();

            min.offer(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[] { new Interval(2, 3), new Interval(3, 4), new Interval(5, 6) };
        int[] result = NextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
        System.out.println();

        intervals = new Interval[] { new Interval(3, 4), new Interval(1, 5), new Interval(4, 6) };
        result = NextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
    }
}
