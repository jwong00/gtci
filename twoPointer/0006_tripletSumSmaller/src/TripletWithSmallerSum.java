import java.util.*;

class TripletWithSmallerSum {
    public static void main(String[] args) {
        System.out.println(searchTriplets(new int[]{-1,0,2,3},3));
        System.out.println(searchTriplets(new int[]{-1,4,2,1,3},5));
    }

    public static int searchTriplets(int[] arr, int target) {
        if(arr==null || arr.length<3) return 0;

        Arrays.sort(arr);

        int count = 0;
        for(int i=0;i<arr.length-2;i++) {
            int l = i+1, r = arr.length-1;

            while(l < r) {
                int t_val = arr[i] + arr[l] + arr[r];

                if( t_val < target ) {
                    count += r-l;
                    l++;
                }
                else r--;

            }
        }

        return count;
    }
}