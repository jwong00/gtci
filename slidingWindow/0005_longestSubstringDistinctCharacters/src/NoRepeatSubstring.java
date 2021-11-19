import java.util.*;

class NoRepeatSubstring {
    public static void main(String[] args) {
        System.out.println(findLength("aabccbb"));
    }
    public static int findLength(String str) {
        HashSet<Character> set = new HashSet<>();
        int width = 0;

        for(int i=0,j=0;j<str.length();j++) {
            if(set.contains(str.charAt(j))) {
//                while(set.contains(str.charAt(j))) {
//                    set.remove(str.charAt(i));
//                    i++;
//                }
                i = Math.max(i,j-i+1);

            }

            set.add(str.charAt(j));

            width = Math.max(width,j-i+1);

        }
        return width;
    }
}
