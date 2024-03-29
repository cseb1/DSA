package LeetcodeProblem.MediumType;

 public class BrowserHistory {

    class Node{
        String pageName;
        Node prev;
        Node next;
        
        Node(){

        }

        Node(String pageName){
            this.pageName = pageName;
        }


    }

    Node head;
    Node tail;
    Node currPage;

    public BrowserHistory(String homepage) {

        head = new Node(homepage);
        tail = head;
        currPage = head;
        
    }
    
    public void visit(String url) {

        Node newPage = new Node(url);

        currPage.next = newPage;
        newPage.prev = currPage;
        tail = currPage = newPage;
        
    }
    
    public String back(int steps) {

        while(steps > 0){

            if(currPage == head){
               return currPage.pageName;
           }
           
           currPage = currPage.prev;
           steps--;


        }

        return currPage.pageName;
        
    }
    
    public String forward(int steps) {

        while(steps >0){

            if(currPage == tail){
               return currPage.pageName;
           }
           
           currPage = currPage.next;
           steps--;


        }

        return currPage.pageName;   
    }

    public static void main(String[] args) {
        BrowserHistory obj=new BrowserHistory("Google.com");
        obj.visit("linkedin.com");
        obj.visit("xnxx.com");
        obj.visit("xvxx.com");
        obj.visit("Youtube.com");
        System.out.println(obj.back(1));
        System.out.println(obj.forward(1));

    }
}

