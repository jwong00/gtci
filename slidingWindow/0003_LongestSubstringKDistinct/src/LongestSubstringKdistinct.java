import javax.xml.transform.SourceLocator;
import java.util.*;

class LongestSubstringKDistinct {
    public static void main(String[] args) {
        System.out.println(findLength("araaci",2));
    }
    public static int findLength(String str, int k) {
        HashMap<Character,Integer> freq = new HashMap<>();

        int width = 0;

        for(int i=0,j=0;i<str.length();i++) {
            char rightChar = str.charAt(i);
            freq.put(rightChar,freq.getOrDefault(rightChar,0)+1);

            while(freq.size() > k) {
                char leftChar = str.charAt(j);
                freq.put(leftChar,freq.get(leftChar)-1);
                if(freq.get(leftChar)==0) freq.remove(leftChar);
                j++;
            }

            width = Math.max(width,i-j+1);
        }

        return width;
    }
}
