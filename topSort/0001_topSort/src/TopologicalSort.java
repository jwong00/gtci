import java.util.*;

class TopologicalSort {
    public static List<Integer> sort(int vertices, int[][] edges) {
        // TODO: Write your code here

        //init
        HashMap<Integer,List<Integer>> adj = new HashMap<>();
        HashMap<Integer,Integer> inDegrees = new HashMap<>();
        for(int i=0;i<vertices;i++) {
            inDegrees.put(i,0);
            adj.put(i,new ArrayList<Integer>());
        }

        //build graph
        for(int i=0;i<edges.length;i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            inDegrees.put(edges[i][1],inDegrees.get(edges[i][1])+1);
        }

        //store 0-indegree nodes in a queue
        Deque<Integer> sources = new ArrayDeque<>();
        for(Map.Entry<Integer,Integer> inDegree : inDegrees.entrySet()) {
            if(inDegree.getValue()==0) sources.add(inDegree.getKey());
        }

        //sort
        List<Integer> sortedOrder = new ArrayList<>();

        while(!sources.isEmpty()) {
            int source = sources.poll();
            sortedOrder.add(source);

            for(int child : adj.get(source)) {
                inDegrees.put(child,inDegrees.get(child)-1);
                if(inDegrees.get(child)==0) sources.offer(child);
            }
        }

        //cycle detection and return
        if(sortedOrder.size()!=vertices) return new ArrayList<>();
        else return sortedOrder;
    }

    public static void main(String[] args) {
        List<Integer> result = TopologicalSort.sort(4,
                new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        System.out.println(result);

        result = TopologicalSort.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
                new int[] { 2, 1 }, new int[] { 3, 1 } });
        System.out.println(result);

        result = TopologicalSort.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
                new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
        System.out.println(result);
    }
}
