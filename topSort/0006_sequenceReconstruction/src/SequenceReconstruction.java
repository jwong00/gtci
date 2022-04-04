import java.util.*;

class SequenceReconstruction {
    public static boolean canConstruct(int[] originalSeq, int[][] sequences) {

        if(originalSeq.length<=0) return false;
        //init
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        HashMap<Integer,Integer> indegrees = new HashMap<>();

        for(int[] seq : sequences) {
            for(int i=0;i<seq.length;i++) {
                graph.putIfAbsent(seq[i], new ArrayList<>());
                indegrees.putIfAbsent(seq[i], 0);
            }
        }

        //build graph

//        for (int[] seq : sequences) {
//            for (int i = 1; i < seq.length; i++) {
//                int parent = seq[i - 1], child = seq[i];
//                graph.get(parent).add(child);
//                indegrees.put(child, indegrees.get(child) + 1);
//            }
//        }
        for(int i=0;i<sequences.length;i++) {
            for(int j=1;j < sequences[i].length;j++) {
                graph.get(sequences[i][j-1]).add(sequences[i][j]);
                indegrees.put(sequences[i][j],indegrees.get(sequences[i][j])+1);
            }
        }

        if(indegrees.size()!= originalSeq.length) return false;

        //determine sources
        Deque<Integer> sources = new ArrayDeque<>();
        for(Map.Entry<Integer,Integer> e : indegrees.entrySet()) {
            if(e.getValue()==0) sources.add(e.getKey());
        }

        //generate all possible topological orders
        List<Integer> sortedOrder = new ArrayList<>();
        while(!sources.isEmpty()) {
            if(sources.size()>1) return false;
            if(originalSeq[sortedOrder.size()]!=sources.peek()) return false;
            int source = sources.poll();
            sortedOrder.add(source);
            List<Integer> children = graph.get(source);
            for(int child : children) {
                indegrees.put(child,indegrees.get(child)-1);
                if(indegrees.get(child)==0) sources.add(child);
            }
        }

        return sortedOrder.size()==originalSeq.length;
    }

    public static void main(String[] args) {
        boolean result = SequenceReconstruction.canConstruct(new int[] { 1, 2, 3, 4 },
                new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 3, 4 } });
        System.out.println("Can we uniquely construct the sequence: " + result);

        result = SequenceReconstruction.canConstruct(new int[] { 1, 2, 3, 4 },
                new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 2, 4 } });
        System.out.println("Can we uniquely construct the sequence: " + result);

        result = SequenceReconstruction.canConstruct(new int[] { 3, 1, 4, 2, 5 },
                new int[][] { new int[] { 3, 1, 5 }, new int[] { 1, 4, 2, 5 } });
        System.out.println("Can we uniquely construct the sequence: " + result);
    }
}
