import java.util.Random;

public class RandomString {
    static String genarate(int size) {
        StringBuffer sb = new StringBuffer(size);

        Random random = new Random();

        for (int i = 0; i < size; i++) {
            int randomChar = 97 + (int) (random.nextFloat() * 26);
            sb.append((char) randomChar);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int size = 20;
        System.out.println(genarate(size));
    }
}
