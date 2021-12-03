import java.util.*;

class TripletSumCloseToTarget {
    public static void main(String[] args) {
        System.out.println(searchTriplet(new int[]{-2,0,1,2},2));
        System.out.println(searchTriplet(new int[]{-3,-1,1,2},1));
        System.out.println(searchTriplet(new int[]{1,0,1,1},2));
    }

    public static int searchTriplet(int[] arr, int targetSum) {
        Arrays.sort(arr);

//        int[]   t;
        int     t_dist_min  = Integer.MAX_VALUE;
        int     t_sum_min   = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length-2; i++) {

            //skip duplicates
//            if(i > 0 && arr[i]==arr[i - 1]) continue;

            int l = i + 1, r = arr.length - 1;

            while(l < r) {
                int t_sum_cur = arr[i] + arr[l] + arr[r];
                int t_dist_cur = Math.abs(targetSum - t_sum_cur);

                if(t_sum_cur==targetSum) return t_sum_cur;
                if(t_dist_cur < t_dist_min && t_sum_cur < t_sum_min) {
                    t_dist_min = t_dist_cur;
                    t_sum_min = t_sum_cur;
//                    t = new int[] {arr[i],arr[l],arr[r]};
                }

                if(t_sum_cur < targetSum) l++;
                if(t_sum_cur > targetSum) r--;

            }

        }

        return t_sum_min;
    }
}
