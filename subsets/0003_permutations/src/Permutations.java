import java.util.*;

class Permutations {

    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> permutations = new LinkedList<>();
        permutations.add(new ArrayList<>());

        for(int i=0;i<nums.length;i++) {
            int n = permutations.size();

            for(int j=0;j<n;j++) {
                List<Integer> oldPermutation = permutations.poll();

                for(int k=0;k<=oldPermutation.size();k++) {
                    List<Integer> newPermutation = new ArrayList<Integer>(oldPermutation);
                    newPermutation.add(k,nums[i]);

                    if(newPermutation.size()==nums.length) result.add(newPermutation);
                    else permutations.add(newPermutation);
                }
            }
        }

        // TODO: Write your code here
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }
}
