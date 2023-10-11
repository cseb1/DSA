import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
       /* 
        Suppose one organisation there are 5 students.
        Q. Store their roll no corresponding their name.
            Ans. we create Simply one by one variable & store their corresponding roll no

        */

        int s1=33;
        int s2=44;
        int s3=78;
        int s4=90;
        int s5=87;
        System.out.println("All Students roll no is/are->"+s1+","+ s2+","+ s3+","+s4+ ","+ s5);


        /*
          But here are one problem is when their are more student like 1000, then its very hard
          problem to store their roll no
          that's why use an data structure that is Array.
          Array->An array is a collection of items of same data type stored at contiguous memory locations.
         but in java its depends to the JVM it's contiguos or not.
          */

        // Array Declaration

            // dataType [] arrayName= new dataType[Array_Size];
        int []arr;

        // Array Initialisation

        arr=new int [5];

        // one more ways

      int []a={4,5,7,3,2};
     

      //print the element
        System.out.println(Arrays.toString(arr));
      System.out.println(a[0]);

     for(int i=0;i<a.length;i++)
     {
        System.out.print(a[i]+" ");
     }
    










    }
}
