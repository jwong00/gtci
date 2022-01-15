import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
};

class MergeIntervals {

    public static List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()<2) return intervals;

        //sort intervals
        Collections.sort(intervals,(a,b)->Integer.compare(a.start,b.start));

        List<Interval> mergedIntervals = new LinkedList<Interval>();

        //get initial interval
        Iterator<Interval> int_iter = intervals.iterator();
        Interval interval = int_iter.next();
        int start = interval.start;
        int end = interval.end;

        //iterate over intervals
        //set new as current when non overlap detected
        while(int_iter.hasNext()) {
            interval = int_iter.next();
            if(interval.start <= end) {
                end = Math.max(interval.end,end);
            }
            else {
                mergedIntervals.add(new Interval(start,end));
                start = interval.start;
                end = interval.end;
            }
        }

        mergedIntervals.add(new Interval(start,end));

        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}
