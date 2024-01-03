import java.util.Arrays;

public class String_Buffer {
    public static void main(String[] args) {

        // constructor 1

        StringBuffer sb = new StringBuffer();

        // constructor no 2
        StringBuffer sb2 = new StringBuffer("Sreya Das");
        System.out.println(sb2.capacity());

        // constructor no 3

        StringBuffer sb3 = new StringBuffer(30);
        System.out.println(sb3.capacity());

        // method
        sb.append("Susanta");
        sb.append(" love Sreya");

        // sb.insert(7, " Really");

        // sb.replace(1, 5, "Kunal");

        // sb.delete(1, 4);

        // sb.reverse();

        String str = sb.toString();
        System.out.println(str);

        // remove whaitespaces
        String sentence = " hii    My  name is  Susanta";
        System.out.println(sentence);
        System.out.println(sentence.replaceAll("\\s", ""));

        // split the string very important

        String input = "Susanta,Sayan,Anjan,Mirza";
        String[] arr = input.split(",");
        System.out.println(arr[1]);
        System.out.println(Arrays.toString(arr));

    }
}
