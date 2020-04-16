public class MathModule {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try {  
			int test = myMultiply(-2000000000, 6);  
			System.out.println(test); 
		} catch(Exception e) {
			System.out.println(e.toString()); 
		} 
		try {
			double test = myDivsion(20,3);
			System.out.println(test);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public static int myMultiply(int firstNum, int secondNum) throws Exception {
		long newAnswer = (long)firstNum * secondNum; 
		if ((newAnswer > Integer.MAX_VALUE)||(newAnswer < Integer.MIN_VALUE)) {
			throw new Exception("Number out of range");
		}
		return firstNum * secondNum; 
	}
	
	public static double myDivsion(double firstNum, double secondNum) throws Exception {
		if (secondNum==0) {
			throw new Exception("devide by zero");
		}
		double quo=firstNum / secondNum;
		quo=(Math.round(quo*100))/100.0;
		return quo; 
	}
}