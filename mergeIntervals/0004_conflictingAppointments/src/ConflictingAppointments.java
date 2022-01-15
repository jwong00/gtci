import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public String toString() {
        return "["+start+","+end+"]";
    }
};

class ConflictingAppointments {

    public static boolean canAttendAllAppointments(Interval[] intervals) {
        if(intervals==null || intervals.length<=1) return true;

        Arrays.sort(intervals,(a,b)->Integer.compare(a.start,b.start));

        int start = intervals[0].start, end = intervals[0].end;
        for(int i=1;i<intervals.length;i++) {
            if(intervals[i].start < end) return false;

            start = intervals[i].start;
            end = intervals[i].end;
        }
        return true;
    }


    public static List<Interval> findConflictingAppointments(Interval[] intervals) {
        if(intervals==null || intervals.length<=1) return new ArrayList<Interval>();

        Arrays.sort(intervals,(a,b)->Integer.compare(a.start,b.start));

        List<Interval> conflictingAppointments = new ArrayList<Interval>();
        int start = intervals[0].start, end = intervals[0].end;
        for(int i=1;i<intervals.length;i++) {
            if(intervals[i].start < end) conflictingAppointments.add(intervals[i]);

            start = intervals[i].start;
            end = intervals[i].end;
        }
        return conflictingAppointments;
    }

    public static void main(String[] args) {
        Interval[] intervals = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
        boolean result = ConflictingAppointments.canAttendAllAppointments(intervals);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals1 = { new Interval(6, 7), new Interval(2, 4), new Interval(8, 12) };
        result = ConflictingAppointments.canAttendAllAppointments(intervals1);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals2 = { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) };
        result = ConflictingAppointments.canAttendAllAppointments(intervals2);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals3 = { new Interval(4,5), new Interval(2,3),
                new Interval(3,6), new Interval(5,7), new Interval(7,8)};
        List<Interval> conflicts = ConflictingAppointments.findConflictingAppointments(intervals3);
        System.out.println("In conflict: " + conflicts);
    }
}
