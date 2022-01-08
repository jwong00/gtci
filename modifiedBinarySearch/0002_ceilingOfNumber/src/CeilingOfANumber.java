class CeilingOfANumber {

    public static int searchCeilingOfANumber(int[] arr, int key) {
        int l = 0, r = arr.length - 1, m = l + (r - l) / 2;

        if(key > arr[r]) return -1;

        while(l<=r) {
            m = l + (r - l) / 2;

            if(arr[m]==key) return m;

            if(arr[m] < key) l = m + 1;
            if(arr[m] > key) r = m - 1;
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6));
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17));
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1));
    }
}
