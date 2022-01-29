import java.util.*;

class Entry {
    int key;
    int value;

    public Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class KClosestElements {

    public static List<Integer> findClosestElements(int[] arr, int K, Integer X) {
        PriorityQueue<Entry> heap = new PriorityQueue<>((a,b) -> b.value-a.value);

        int i=0;

        while(i < K) {

            heap.add(new Entry(arr[i],Math.abs(arr[i] - X)));
            i++;
        }

        while(i < arr.length) {
            if( Math.abs(arr[i] - X) < heap.peek().value ) {
                heap.poll();
                heap.add(new Entry(arr[i],Math.abs(arr[i] - X)));
            }
            i++;
        }

        List<Integer> result = new ArrayList<>();

        while(heap.size() > 0) {
            result.add(heap.poll().key);
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = KClosestElements.findClosestElements(new int[] { 5, 6, 7, 8, 9 }, 3, 7);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 6);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 10);
        System.out.println("'K' closest numbers to 'X' are: " + result);
    }
}
