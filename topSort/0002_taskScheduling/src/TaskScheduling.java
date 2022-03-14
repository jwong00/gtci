import java.util.*;

class TaskScheduling {
    public static boolean isSchedulingPossible(int tasks, int[][] prerequisites) {
        // TODO: Write your code here
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        HashMap<Integer,Integer> indegrees = new HashMap<>();

        //init
        for(int i=0;i<tasks;i++) {
            graph.put(i,new ArrayList<>());
            indegrees.put(i,0);
        }

        //build graph
        for(int[] prerequisite : prerequisites) {
            graph.get(prerequisite[0]).add(prerequisite[1]);
            indegrees.put(prerequisite[1],indegrees.get(prerequisite[1])+1);
        }

        //determine sources
        Deque<Integer> sources = new ArrayDeque<>();
        for(Map.Entry<Integer,Integer> vertex : indegrees.entrySet()) {
            if(vertex.getValue()==0) sources.add(vertex.getKey());
        }

        //iterate over sources
//        int schedule = 0;
        List<Integer> schedule = new ArrayList<>();
        while(!sources.isEmpty()) {
            int vertex = sources.poll();
            schedule.add(vertex);


            for(int child : graph.get(vertex)) {
                indegrees.put(child,indegrees.get(child)-1);
                if(indegrees.get(child)==0) sources.add(child);
            }

        }

        return schedule.size()==tasks;

    }

    public static void main(String[] args) {

        boolean result = TaskScheduling.isSchedulingPossible(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println("Tasks execution possible: " + result);

        result = TaskScheduling.isSchedulingPossible(3,
                new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
        System.out.println("Tasks execution possible: " + result);

        result = TaskScheduling.isSchedulingPossible(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 },
                new int[] { 0, 4 }, new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
        System.out.println("Tasks execution possible: " + result);
    }
}
