public class DynamicStack extends CustomStack {

    public DynamicStack() {
        super();
    }

    public DynamicStack(int size) {
        super(size);
    }

    @Override
    public boolean push(int item) {
        if (this.isFull()) {
            // double the array Size
            int[] temp = new int[data.length * 2];

            // copy all previous item into new data array
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }
        // Now we know that the array is not full....
        // So, we just insert the item
        return super.push(item);
    }
}
