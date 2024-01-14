public class Main {
    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>();
        heap.insert(45);
        heap.insert(65);
        heap.insert(35);
        heap.insert(55);
        heap.insert(85);
        heap.insert(15);

        System.out.println(heap.heapSort());
    }
}
