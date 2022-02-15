import java.util.*;

class Meeting {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public String toString() {
        return "["+start+","+end+"]";
    }
};

class MinimumMeetingRooms {

    public static int findMinimumMeetingRooms(List<Meeting> meetings) {
        if(meetings==null || meetings.size() < 1) return 0;
        else if(meetings.size()==1) return 1;

        Collections.sort(meetings,(a,b)->Integer.compare(a.start,b.start));

        System.out.println(meetings);

       int minRooms = 0;

       PriorityQueue<Meeting> heap = new PriorityQueue<>(meetings.size(),(a,b)->Integer.compare(a.end,b.end));

       for(Meeting m :meetings) {
           while(!heap.isEmpty() && m.start >= heap.peek().end) {
                heap.poll();
           }
           heap.offer(m);
           minRooms = Math.max(minRooms,heap.size());
       }



        return minRooms;
    }

    public static void main(String[] args) {
        List<Meeting> input = new ArrayList<Meeting>() {
            {
                add(new Meeting(4, 5));
                add(new Meeting(2, 3));
                add(new Meeting(2, 4));
                add(new Meeting(3, 5));
            }
        };
        int result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 5));
                add(new Meeting(7, 9));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(6, 7));
                add(new Meeting(2, 4));
                add(new Meeting(8, 12));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 3));
                add(new Meeting(3, 6));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(4, 5));
                add(new Meeting(2, 3));
                add(new Meeting(2, 4));
                add(new Meeting(3, 5));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);
    }
}
