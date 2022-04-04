class Knapsack {

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        // TODO: Write your code here
        Integer[][] memo = new Integer[profits.length][capacity+1];
        return helper(profits,weights,capacity,0,memo);
    }

    public int helper(int[] profits, int[] weights, int capacity, int index,Integer[][] memo) {

        //base case
        if(index<0 || index >= profits.length) return 0;

        //return if already solved:
        if(memo[index][capacity]!=null) return memo[index][capacity];

        //0/1 selection is a calculation of profit with that selection:
        int profit1 = 0;

        if(weights[index]<=capacity)
            profit1 = profits[index]+helper(profits,weights,capacity-weights[index],index+1,memo);

        int profit2 = helper(profits,weights,capacity,index+1,memo);

        memo[index][capacity] = Math.max(profit1,profit2);

        return memo[index][capacity];

    }

    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
//        int[] profits = {1, 6, 10, 16};
//        int[] weights = {1, 2, 3, 5};
        int[] profits = {4,5,3,7,4,7,8,2,8,1,1,4};
        int[] weights = {2,3,1,4,2,7,9,2,6,3,5,1};
        int maxProfit = ks.solveKnapsack(profits, weights, 13);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
