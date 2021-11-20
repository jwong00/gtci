import java.util.HashMap;

class CharacterReplacement {
    public static int findLength(String str, int k) {
        // TODO: Write your code here
        HashMap<Character,Integer> letters = new HashMap<>();

        int width = 0;

        for(int i=0,j=0;j<str.length();j++) {
            letters.put(str.charAt(j),letters.getOrDefault(str.charAt(j),0)+1);

            while(letters.size()> k+1) {
                letters.put(str.charAt(i),letters.get(str.charAt(i))-1);
                if(letters.get(str.charAt(i))==0) letters.remove(str.charAt(i));
                i++;
            }

            width = Math.max(width,j-i+1);
        }

        return width;
    }
}
