import java.util.*;

class RearrangeStringKDistanceApart {

    public static String reorganizeString(String str, int k) {
        HashMap<Character,Integer> hash_str = new HashMap<>();

        for(int i=0;i<str.length();i++) {
            hash_str.put(str.charAt(i), hash_str.getOrDefault(str.charAt(i),0)+1);
        }

        PriorityQueue<Map.Entry<Character,Integer>> heap = new PriorityQueue<>((a,b) -> b.getValue()-a.getValue());

        heap.addAll(hash_str.entrySet());

        Queue<Map.Entry<Character,Integer>> previous = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        while(!heap.isEmpty()) {
            Map.Entry<Character,Integer> current = heap.poll();

            sb.append(current.getKey());
            current.setValue(current.getValue()-1);
            previous.offer(current);

            if(previous.size() == k) {
                Map.Entry<Character,Integer> cache = previous.poll();
                if(cache.getValue() > 0) heap.add(cache);
            }
        }

        return sb.length()==str.length() ? sb.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("mmpp", 2));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("Programming", 3));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("aab", 2));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("aappa", 3));
    }
}
