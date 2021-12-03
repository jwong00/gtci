import java.util.*;

class SubarrayProductLessThanK {

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();
        // TODO: Write your code here

        for(int i=1;i<arr.length;i++) {
            arr[i] *= arr[i-1];
        }

        for(int st_idx = 0;st_idx<arr.length;st_idx++) {
            
        }

        return subarrays;
    }
}
