import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
};

class IntervalsIntersection {

    public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
        List<Interval> intervalsIntersection = new ArrayList<Interval>();

//        if(arr1==null || arr2==null || arr1.length==0 || arr2.length==0)
//            return intervalsIntersection.toArray(new Interval[intervalsIntersection.size()]);

        int i=0,j=0;
        while(i<arr1.length && j<arr2.length) {
            if(intersect(arr1[i],arr2[j]))
                intervalsIntersection.add(
                        new Interval(Math.max(arr1[i].start,arr2[j].start),Math.min(arr1[i].end,arr2[j].end))
                );
            if(arr1[i].end <= arr2[j].end) i++;
            else j++;
        }

        return intervalsIntersection.toArray(new Interval[intervalsIntersection.size()]);
    }

    public static boolean intersect(Interval a, Interval b) {
        return (a.start >= b.start && a.start <= b.end) ||
                (b.start >= a.start && b.start <= a.end);
    }


    public static void main(String[] args) {
        Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
        Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
        Interval[] result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
        input2 = new Interval[] { new Interval(5, 10) };
        result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
    }
}
