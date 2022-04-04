import java.util.*;

class TaskSchedulingOrder {
    public static List<Integer> findOrder(int tasks, int[][] prerequisites) {

        //init
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        HashMap<Integer,Integer> indegrees = new HashMap<>();

        for(int i=0;i<tasks;i++) {
            graph.put(i,new ArrayList<>());
            indegrees.put(i,0);
        }

        //build graph
        for(int[] prerequisite : prerequisites) {
            graph.get(prerequisite[0]).add(prerequisite[1]);
            indegrees.put(prerequisite[1],indegrees.get(prerequisite[1])+1);
        }

        //determine sources (0-indegrees)
        Deque<Integer> sources = new ArrayDeque<>();
        for(Map.Entry<Integer,Integer> entry : indegrees.entrySet()) {
            if(entry.getValue()==0) sources.offer(entry.getKey());
        }

        //build task schedule order
        List<Integer> sortedOrder = new ArrayList<>();

        while(!sources.isEmpty()) {
            int task = sources.poll();
            sortedOrder.add(task);

            for(int child : graph.get(task)) {
                indegrees.put(child,indegrees.get(child)-1);
                if(indegrees.get(child)==0) sources.add(child);
            }
        }

        //check if DAG and return
        if(sortedOrder.size()!=tasks) return new ArrayList<>();
        else return sortedOrder;
    }

    public static void main(String[] args) {
        List<Integer> result = TaskSchedulingOrder.findOrder(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println(result);

        result = TaskSchedulingOrder.findOrder(3,
                new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
        System.out.println(result);

        result = TaskSchedulingOrder.findOrder(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 },
                new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
        System.out.println(result);
    }
}
