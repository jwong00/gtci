class NextLetter {

    public static char searchNextLetter(char[] letters, char key) {
        int n = letters.length;

        int l = 0, r = n - 1;

        while(l<=r) {
            int m = l + (r - l) / 2;
            if(letters[m] <= key) l = m + 1;
            if(letters[m] > key) r = m - 1;

        }
        return letters[l % n];
    }

    public static void main(String[] args) {
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
    }
}
