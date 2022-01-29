import java.util.*;

class ConnectRopes {

    public static int minimumCostToConnectRopes(int[] ropeLengths) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int i=0;i<ropeLengths.length;i++) {
            heap.add(ropeLengths[i]);
        }

        int score = 0;

        while(heap.size()>1) {
            int newRope = heap.poll() + heap.poll();
            heap.add(newRope);
            score+=newRope;
        }

        return score;
    }

    public static void main(String[] args) {
        int result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
        System.out.println("Minimum cost to connect ropes: " + result);
    }
}
