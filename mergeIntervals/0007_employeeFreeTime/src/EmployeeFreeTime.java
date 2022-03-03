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

class EmployeeFreeTime {

    public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {

        //merge all intervals first
        List<List<Interval>> schedule_merged = new ArrayList<>();

        for(List<Interval> s : schedule) {
            List<Interval> s_merged = new ArrayList<>();
            Iterator<Interval> i = s.iterator();
            Interval cur = i.next();
            int start = cur.start, end = cur.end;

            while(i.hasNext()) {
                cur = i.next();

                if(end >= cur.start) {
                    end = Math.max(end,cur.end);
                }
                else {
                    s_merged.add(new Interval(start,end));
                    start = cur.start;
                    end = cur.end;
                }
            }

            s_merged.add(new Interval(start,end));

            schedule_merged.add(s_merged);
        }

        System.out.println("SCHEDULE_MERGED"+schedule_merged);

        //invert intervals
        List<List<Interval>> schedule_inverted = new ArrayList<>();

        for(List<Interval> s : schedule_merged) {
            List<Interval> s_inverted = new ArrayList<>();
            Iterator<Interval> i = s.iterator();
            Interval cur = i.next();
            int start = cur.start, end = cur.end;

            while(i.hasNext()) {
                cur = i.next();

                s_inverted.add(new Interval(end,cur.start));

                start = cur.start;
                end = cur.end;
            }

//            s_inverted.add(new Interval(end,cur.start));

            schedule_inverted.add(s_inverted);

        }

        System.out.println("SCHEDULE_INVERTED"+schedule_inverted);

        List<Interval> result = new ArrayList<>();
        // TODO: Write your code here
        return result;
    }

    public static void main(String[] args) {

        List<List<Interval>> input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
        List<Interval> result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(6, 8))));
        result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(3, 5), new Interval(7, 9))));
        result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
    }
}
