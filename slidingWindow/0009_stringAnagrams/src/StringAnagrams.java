import java.sql.SQLOutput;
import java.util.*;

class StringAnagrams {
    public static void main(String[] args) {
        System.out.println(findStringAnagrams("ppqp","pq"));
    }
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();

        HashMap<Character,Integer> _pattern = new HashMap<>();

        for(int i=0;i<pattern.length();i++) {
            char key = pattern.charAt(i);
            _pattern.put(key,_pattern.getOrDefault(key,0)+1);
        }

        HashMap<Character,Integer> _str = new HashMap<>();

        for(int i=0,j=0;j<str.length();j++) {
            char key = str.charAt(j);
            _str.put(key,_str.getOrDefault(key,0)+1);

            if(j>pattern.length()-1) {
                key = str.charAt(i);
                _str.put(key,_str.get(key)-1);
                if(_str.get(key)==0) _str.remove(key);
                i++;
            }

            if(_str.equals( _pattern)) resultIndices.add(i);
        }

        return resultIndices;
    }
}
