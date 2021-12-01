class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = new int[] {2,3,3,3,6,9,9};
        System.out.println(remove(arr));
    }
    public static int remove(int[] arr) {
        int i=1;

        for(int j=1;j<arr.length;j++) {
            if(arr[i-1] != arr[j]) {
                arr[i] = arr[j];
                i++;
            }

        }

        return i;
    }
}
