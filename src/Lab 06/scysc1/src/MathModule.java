public class MathModule {

    public static void main(String[] args) {

        try {
            int test = myMultiply(2000000000, 6);
            System.out.println(test);
        } catch(Exception e) {
            System.out.println(e.toString());
        }
        try {
            int test = myDivide(2000000000, 0);
            System.out.println(test);
        } catch(Exception e) {
            System.out.println(e.toString());
        }


    }

    public static int myMultiply(int firstNum, int secondNum) throws Exception {
        long newAnswer = (long) firstNum * secondNum;
        if (newAnswer > Integer.MAX_VALUE || newAnswer < Integer.MIN_VALUE) {
            throw new Exception("Number too big");
        }
        return firstNum * secondNum;
    }

    public static int myDivide(int firstNum, int secondNum) throws Exception {
        long newAnswer = (long) firstNum / secondNum;
        if (newAnswer > Integer.MAX_VALUE || newAnswer < Integer.MIN_VALUE) {
            throw new Exception("Number too big");
        }
        else if (firstNum % secondNum != 0)
        {
            throw new Exception("Cannot be divided fully");
        }
        return firstNum / secondNum;
    }
}
