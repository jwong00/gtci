import java.util.*;

class TripletSumCloseToTarget {
    public static void main(String[] args) {
        System.out.println(searchTriplet(new int[]{-2,0,1,2},2));
        System.out.println(searchTriplet(new int[]{-3,-1,1,2},1));
        System.out.println(searchTriplet(new int[]{1,0,1,1},2));
    }

    public static int searchTriplet(int[] arr, int targetSum) {

        Arrays.sort(arr);

        int best = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length-2; i++) {

            //skip duplicates
//            if(i > 0 && arr[i]==arr[i - 1]) continue;

            int l = i + 1, r = arr.length - 1;


            while(l < r) {
//                int t_sum_cur = arr[i] + arr[l] + arr[r];
//                int t_dist_cur = Math.abs(targetSum - t_sum_cur);
                int t_dist_cur = targetSum - arr[i] - arr[l] - arr[r];

                if(t_dist_cur==0) return targetSum;

                if(     Math.abs(targetSum) <  Math.abs(best) ||
                        (Math.abs(targetSum)==Math.abs(best) && targetSum > best) )
                    best = targetSum;

                if(t_dist_cur > 0) l++;
                if(t_dist_cur < 0) r--;

            }

        }

        return targetSum - best;
    }
}
