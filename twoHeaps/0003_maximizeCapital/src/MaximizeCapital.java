import java.util.*;

class MaximizeCapital {

    public static class Pair {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public String toString() {
            return "["+value+","+index+"]";
        }
    }
    public static int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {

        PriorityQueue<Integer> min = new PriorityQueue<>((a,b)->capital[a]-capital[b]);
        PriorityQueue<Integer> max = new PriorityQueue<>((a,b)->capital[b]-capital[a]);

        //add all projects to min-heap
        for(int i=0;i<capital.length;i++) {
            min.add(i);
        }
//        System.out.println(min);

        int currentCapital = initialCapital;

        while(numberOfProjects>0) {

            //filter projects that can be completed into max-heap
            while(!min.isEmpty() && capital[min.peek()]<= currentCapital ) {
                max.add(min.poll());
            }

            //escape from loop if no projects
            if(max.isEmpty()) break;

            //select the top project
            currentCapital += profits[max.poll()];

            numberOfProjects--;

        }

        return currentCapital;
    }

    public static void main(String[] args) {
        int result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 2, 1);
        System.out.println("Maximum capital: " + result);
        result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2, 3 }, new int[] { 1, 2, 3, 5 }, 3, 0);
        System.out.println("Maximum capital: " + result);
    }
}
