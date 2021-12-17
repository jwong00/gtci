class SingleNumber {
    public static int findSingleNumber(int[] arr) {
        int k = arr[0];
        for(int i=1;i<arr.length;i++) {
            k ^= arr[i];
        }
        return k;
    }

    public static void main( String args[] ) {
        System.out.println(findSingleNumber(new int[]{1, 4, 2, 1, 3, 2, 3}));
    }
}
