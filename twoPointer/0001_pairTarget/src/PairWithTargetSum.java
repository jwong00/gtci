class PairWithTargetSum {

    public static int[] search(int[] arr, int targetSum) {
        int l = 0,r = arr.length-1;
        while(l<r) {
            if(arr[l]+arr[r]==targetSum) return new int[]{l,r};
            else if(arr[l]+arr[r] > targetSum) l++;
            else r--;
        }

        return new int[] { -1, -1 };
    }
}
