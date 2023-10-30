public class InterviewTester {
    public static void main(String[] args) {
        InterviewQuestion q=new InterviewQuestion();

        if(q.isHappy(10)==true)
        {
            System.out.println("Happy number");
        }
        else
            System.out.println("Not happy number");
    }
}
