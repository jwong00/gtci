import java.util.Arrays;

class SortedArraySquares {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(makeSquares(new int[]{-2,-1,0,2,3})));
    }
    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];

        int l=0, r = arr.length-1;

        for(int j=arr.length-1;j>=0;j--) {

            int l_sq = arr[l] * arr[l];
            int r_sq = arr[r] * arr[r];

            if(l_sq < r_sq) {
                squares[j] = r_sq;
                r--;
            }
            else {
                squares[j] = l_sq;
                l++;
            }
        }

        return squares;
    }
}
