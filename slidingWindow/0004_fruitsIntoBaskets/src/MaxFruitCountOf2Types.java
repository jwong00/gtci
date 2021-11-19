import java.util.*;

class MaxFruitCountOf2Types {
    public static void main(String[] args) {
        System.out.println(findLength(new char[]{'A', 'B', 'C', 'A', 'C'}));

        System.out.println(findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));

    }
    public static int findLength(char[] arr) {
        HashMap<Character,Integer> fruits = new HashMap<>();

        int fruitsMax = 0;
        for(int i=0,j=0;j<arr.length;j++) {
            fruits.put(arr[j],fruits.getOrDefault(arr[j],0)+1);

            while(fruits.size() > 2) {
                fruits.put(arr[i],fruits.get(arr[i])-1);
                if(fruits.get(arr[i])==0) fruits.remove(arr[i]);
                i++;
            }

            fruitsMax = Math.max(fruitsMax,j-i+1);
        }

        return fruitsMax;
    }
}
