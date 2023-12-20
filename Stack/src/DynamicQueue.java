import java.util.Arrays;

public class DynamicQueue extends CircularQueue {
    public DynamicQueue() {
        super();
    }

    public DynamicQueue(int size) {
        super(size);
    }

    @Override

    public boolean insert(int item) {

        // this takes care if it full!!
        if (this.isFull()) {
            // double the array Size
            int[] temp = new int[data.length * 2];

            // copy all previous item into new data array
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[(front + i) % data.length];
            }
            front = 0;
            end = data.length;
            data = temp;
        }

        return super.insert(item);
    }

    @Override
    public String toString() {
        return "Internally Queue will be--> " + Arrays.toString(data);
    }
}
