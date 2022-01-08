class BinarySearch {

    public static int search(int[] arr, int key) {
        if(arr==null || arr.length==0) return -1;
        int n = arr.length;

        boolean ascending = arr[0] < arr[n-1];

        int l = 0, r = n-1, m = l + (r-l)/2;
        while(l<=r) {
            m = l + (r-l)/2;

            if(arr[m]==key) return m;
            else if(ascending) {
                if(arr[m] > key) r = m - 1;
                else l = m + 1;
            }
            else { //if(descending)
                if(arr[m] > key) l = m + 1;
                else r = m - 1;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(BinarySearch.search(new int[] { 4, 6, 10 }, 10));
        System.out.println(BinarySearch.search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
        System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 10));
        System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 4));
    }
}
