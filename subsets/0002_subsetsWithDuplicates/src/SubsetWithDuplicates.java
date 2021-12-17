import java.util.*;

class SubsetWithDuplicates {

    public static List<List<Integer>> findSubsets(int[] nums) {

        HashSet<Integer> nums_uniq = new HashSet<>();

        for(int i=0;i<nums.length;i++) {
            nums_uniq.add(nums[i]);
        }

        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        for(int num : nums_uniq) {
            int n = subsets.size();
            for(int i=0;i<n;i++) {
                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(num);
                subsets.add(set);
            }
        }

        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] { 1, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = SubsetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}
