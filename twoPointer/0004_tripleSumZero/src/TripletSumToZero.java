import java.util.*;

class TripletSumToZero {

    public static List<List<Integer>> searchTriplets(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();

        for(int i=0;i<arr.length-2;i++) {
            if(i>0 && arr[i] == arr[i-1]) continue;

            int l = i+1, r = arr.length-1;

            while(l<r) {
                int val = arr[i]+arr[l]+arr[r];
                if(val<0) l++;
                else if (val>0) r--;
                else {
                    triplets.add(Arrays.asList(arr[i],arr[l],arr[r]));
                    l++;
                    r--;
                    while(l<r && arr[l]==arr[l-1]) l++;
                    while(l<r && arr[r]==arr[r+1]) r--;
                }
            }
        }

        return triplets;
    }
}
