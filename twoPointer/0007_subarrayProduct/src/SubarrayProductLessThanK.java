import java.util.*;

class SubarrayProductLessThanK {

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();
        // TODO: Write your code here

        for(int i=0;i<arr.length;i++) {
            double target_cache = target;

            List<Integer> subarray = new ArrayList<>();

            for(int j = i; j<arr.length;j++) {
                target_cache /= arr[j];

                if(target_cache > 1) {
                    subarray.add(arr[j]);
                    subarrays.add(subarray.clone());
                }
            }
        }



        return subarrays;
    }
}
