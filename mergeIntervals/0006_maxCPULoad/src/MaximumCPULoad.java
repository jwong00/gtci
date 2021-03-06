import java.util.*;

class Job {
    int start;
    int end;
    int cpuLoad;

    public Job(int start, int end, int cpuLoad) {
        this.start = start;
        this.end = end;
        this.cpuLoad = cpuLoad;
    }
};

class MaximumCPULoad {

    public static int findMaxCPULoad(List<Job> jobs) {

        //validation
        if(jobs==null || jobs.size()==0) return 0;

        //sort
        Collections.sort(jobs,(a,b)->Integer.compare(a.start,b.start));

        //overlapping jobs
        int cpu_load_max = 0;
        PriorityQueue<Job> heap = new PriorityQueue<>(jobs.size(),(a,b)->Integer.compare(a.end,b.end));

        for(Job j : jobs) {
            while(!heap.isEmpty() && j.start >= heap.peek().end) heap.poll();

            heap.offer(j);

            //process all jobs in heap to find total CPU usage
            int cpu_load_cur = 0;
            for(Job j2 : heap) {
                cpu_load_cur += j2.cpuLoad;
            }

            cpu_load_max = Math.max(cpu_load_max,cpu_load_cur);
        }

        return cpu_load_max;
    }

    public static void main(String[] args) {
        List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));
    }
}
