class TwoSingleNumbers {

    public static int[] findSingleNumbers(int[] nums) {

        //xor all nums
        int k = nums[0];
        for(int i=1;i<nums.length;i++) {
            k ^= nums[i];
        }

        //get rmb
        int rmb = 1;
        while((rmb & k) == 0) {
            rmb <<= 1;
        }

        int n1=0,n2=0;
        for(int n : nums) {
            if((n & rmb) != 0 )
                n1 ^= n;
            else
                n2^=n;
        }

        return new int[] { n1, n2 };
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 4, 2, 1, 3, 5, 6, 2, 3, 5 };
        int[] result = TwoSingleNumbers.findSingleNumbers(arr);
        System.out.println("Single numbers are: " + result[0] + ", " + result[1]);

        arr = new int[] { 2, 1, 3, 2 };
        result = TwoSingleNumbers.findSingleNumbers(arr);
        System.out.println("Single numbers are: " + result[0] + ", " + result[1]);
    }
}
