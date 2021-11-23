import java.util.*;

class MinimumWindowSubstring {
    public static String findSubstring(String str, String pattern) {
        HashMap<Character,Integer> _pattern = new HashMap<>();

        for(char c : pattern.toCharArray()) {
            _pattern.put(c,_pattern.getOrDefault(c,0)+1);
        }

        int matched = 0;
        for(int i=0,j=0;j<str.length();j++) {
            char key = str.charAt(j);
            if(_pattern.containsKey(key)) {
                _pattern.put(key,_pattern.get(key)-1);
                if(_pattern.get(key)==0) matched++;
            }

            while(matched >= _pattern.size()) {
                key = str.charAt(i);
                _pattern.put(key,_pattern.getOrDefault(key,0)+1);
                i++;

            }
        }
        return "";
    }
}
