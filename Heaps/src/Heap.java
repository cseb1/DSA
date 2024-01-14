
import java.util.ArrayList;

class Heap<T extends Comparable<T>> {
    private ArrayList<T> list;

    public Heap() {
        list = new ArrayList<T>();
    }

    private void swap(int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return index * 2 + 1;
    }

    private int right(int index) {
        return index * 2 + 2;
    }

    public void insert(T value) {
        list.add(value);
        upheap(list.size() - 1);
    }

    private void upheap(int i) {
        if (i == 0) {
            return;
        }
        int p = parent(i);
        if (list.get(i).compareTo(list.get(p)) < 0) {
            swap(i, p);
            upheap(p);
        }
    }

    public T remove() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Removing from an empty list");
        }

        T temp = list.get(0);
        T last = list.remove(list.size() - 1);
        if (!list.isEmpty()) {
            list.set(0, last);
            downheap(0);
        }

        return temp;
    }

    private void downheap(int i) {
        int min = i;
        int left = left(i);
        int right = right(i);
        if (left < list.size() && list.get(min).compareTo(list.get(left)) > 0) {
            min = left;
        }
        if (right < list.size() && list.get(min).compareTo(list.get(right)) > 0) {
            min = right;
        }
        if (min != i) {
            swap(min, i);
            downheap(min);
        }
    }

    public ArrayList<T> heapSort() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Removing an element in empty list");
        }
        ArrayList<T> ans = new ArrayList<>();

        while (!list.isEmpty()) {
            ans.add(remove());
        }

        return ans;
    }
}
