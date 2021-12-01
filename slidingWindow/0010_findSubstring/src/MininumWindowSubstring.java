import java.util.*;

class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(findSubstring("aabdec","abc"));
        System.out.println(findSubstring("abdbcaa","abac"));
        System.out.println(findSubstring("adcad","abc"));
    }
    public static String findSubstring(String str, String pattern) {
        System.out.println(str);
        HashMap<Character,Integer> _pattern = new HashMap<>();

        for(char c : pattern.toCharArray()) {
            _pattern.put(c,_pattern.getOrDefault(c,0)+1);
        }

        int matched = 0;
        int minStrLength = Integer.MAX_VALUE;
        String substr = "";

        for(int i=0,j=0;j<str.length();j++) {
            char key = str.charAt(j);
            if(_pattern.containsKey(key)) {
                _pattern.put(key,_pattern.get(key)-1);
                if(_pattern.get(key)==0) matched++;
            }

            if(matched== _pattern.size()) {
                if(j-i+1 < minStrLength) {
                    minStrLength = j-i+1;
                    substr = str.substring(i+1,j+1);
                }
            }

            while(matched >= _pattern.size()) {
                key = str.charAt(i);
                _pattern.put(key,_pattern.getOrDefault(key,0)+1);
                if(_pattern.get(key)==0) matched--;
                i++;
            }

        }
        return substr;
    }
}
