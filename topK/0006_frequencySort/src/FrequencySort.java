import java.util.*;

class FrequencySort {

    public static String sortCharacterByFrequency(String str) {

        //count char freq
        HashMap<Character,Integer> freq = new HashMap<>();

        for(int i=0;i<str.length();i++) {
            freq.put(str.charAt(i),freq.getOrDefault(str.charAt(i),0)+1);
        }


        //heapify
        PriorityQueue<Map.Entry<Character,Integer>> heap = new PriorityQueue<>((a,b)-> b.getValue()-a.getValue());

        heap.addAll(freq.entrySet());

        //return new string
        StringBuilder cache = new StringBuilder();
        while(heap.size()>0) {
            Map.Entry<Character,Integer> e = heap.poll();
            int k = e.getValue();
            while(k>0) {
                cache.append(e.getKey());
                k--;
            }

        }

        return cache.toString();
    }

    public static void main(String[] args) {
        String result = FrequencySort.sortCharacterByFrequency("Programming");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);

        result = FrequencySort.sortCharacterByFrequency("abcbab");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);
    }
}
