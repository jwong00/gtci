class HappyNumber {

    public static boolean find(int num) {
        int slow = num, fast = num;
        do {
            slow = findSquareSum(slow);
            fast = findSquareSum(findSquareSum(fast));
        } while(slow!=fast);

        return slow==1;
    }

    public static int findSquareSum(int num) {
        int ans = 0;
        while(num > 0) {
            ans += (num % 10) * (num % 10);
            num /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(HappyNumber.find(23));
        System.out.println(HappyNumber.find(12));
    }
}
