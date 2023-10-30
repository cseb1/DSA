package Searching.LinearSearch;

public class SearchInString {
    public static void main(String[] args) {
       String name="Susanta Maity" ;
       char target='b';
       System.out.println(searchString2(name,target));
    }
    static int searchString(String name,char target)
    {
        if(name.length()==0)
        {
            return -1;
        }
        

        for(int i=0;i<name.length();i++)
        {
            if(name.charAt(i)==target)
            {
                return i;
            }
        }

        return -1;
    }
     static boolean searchString2(String name,char target)
    {
        if(name.length()==0)
        {
            return false;
        }
        

       for(char ch:name.toCharArray())
       {
            if(ch==target)
            {
                return true;
            }
       }
        return false;
    }
}
