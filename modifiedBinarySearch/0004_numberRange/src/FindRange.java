class FindRange {

    public static int[] findRange(int[] arr, int key) {
        int[] result = new int[] { -1, -1 };
        // TODO: Write your code here
        return result;
    }
    private static int searchCeilingOfANumber(int[] arr, int key) {
        if(key > arr[arr.length-1]) return -1;

        int l = 0, r = arr.length-1;

        while(l<=r) {
            int m = l + (r - l) / 2;

            
        }
    }
    private static int searchFloorOfANumber(int[] arr, int key) {
        if(key < arr[0]) return -1;
    }

    public static void main(String[] args) {
        int[] result = FindRange.findRange(new int[] { 4, 6, 6, 6, 9 }, 6);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 10);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 12);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    }
}
