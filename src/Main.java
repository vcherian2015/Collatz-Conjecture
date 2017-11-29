
public class Main {
	
	public static int _count;
	
	public static void main(String args[]) {
		_count = 1;
		g(4636);
		System.out.println("Method calls for g(4636): " + _count);
		System.out.println("Output of g(4636): " + g(4636));
		
		_count = 1;
		gFast(4636);
		System.out.println("Method calls for gFast(4636): " + _count);
		System.out.println("Output of gFast(4636): " + gFast(4636));
		
		_count = 1;
		collatz(4636);
		System.out.println("Method calls for collatz(4636): " + _count);
		System.out.println("Output of collatz(4636): " + collatz(4636));
		
		_count = 1;
		collatzFast(4636);
		System.out.println("Method calls for collatzFast(4636): " + _count);
		System.out.println("Output of collatzFast(4636): " + collatzFast(4636));
	}
	
	/*
	 * This is the original g function. Given the conditions (when a number is odd, subtract it by 1; 
	 * when a number is even, divide it by 2). The output of this method is the amount of times these operations
	 * are applied to a number n for that number to become 1.
	 * Parameters: int n
	 */
	public static int g(int n) {
		if(n==1) {
			return n; //base case. returns 1 to complete the sum
		}
		if(n%2==0) {
			_count++;  
			return 1 + g(n/2);  //adds to the sum and recurses g with a halved n
		}else {
			_count++;
			return 1 + g(n-1);  //adds to the sum and recurses g with a decremented n
		}
	}
	
	/**public static int gFast(int n) {
		int sum = 1;
		while (n!=1) {
			if(n%2==0) {
				sum++;
				n/=2;
			}else {
				sum++;
				n-=1;
			}
		}
		return sum;
	}*/
	
	/*
	 * This method does the exact same thing as the g() method above, but with less method calls. It calls on
	 * gFastPart() to do all the calculations and recursion.
	 * Parameters: int n
	 */
	public static int gFast(int n) {
		_count = 1;
		return gFastPart(n, 1); //calls helper method
	}
	
	/*
	 * This method does all the calculations and recursion for gFast(). It tries to do all the calculations it
	 * can do to n before having to recurse. It first checks if a number is 1, and if so, returns the sum, which
	 * is the accumulated result. Then it checks if a number is odd, and if so, subtracts by 1, and then does ad
	 * while loop to keep dividing the number, if even, by 2 until it no longer can, at which point it recurses.
	 * Parameters: int n, int sum
	 */
	public static int gFastPart(int n, int sum) {
		if(n==1) { 
			return sum; //returns accumulated sum. sum is initiated as 1
		}
		while(n%2!=0) { //checks for odd numbers first. If it was checked second, then, the method would not work if n=2
			sum++; //increments sum
			n -= 1; //decrements n
		}
		while(n%2==0) { //continues to divide n by 2 until it no longer can
			sum++; //increments sum
			n /= 2;  //divides n by 2
		}
		_count++;
		return gFastPart(n, sum); //calls itself
	}
	
	/*public static int gIter(int n) {
		_count = 1;
		return gIterPart(n, 1);
	}
	
	public static int gIterPart(int n, int sum) {
		if(n==1) {
			return sum;
		}
		if (n%2==0) {
			++_count;
			return gIterPart((n/2), ++sum);
		}else {
			++_count;
			return gIterPart((n-1), ++sum);
		}
	}*/
	
	/*
	 * This is the method for the collatz conjecture. If a number is even, then divide it by 2;
	 * if it is odd, it triples it and adds 1. According to the conjecture, all numbers will eventually
	 * reach 1
	 * Parameters: int n
	 */
	public static int collatz(int n) {
		if(n==1) { //checks if number is 1
			return n;  //returns 1, adds to accumulated sum
		}
		if(n%2==0) {  //checks if number is even
			_count++;
			return 1 + collatz(n/2); //adds 1 to sum and divides number by 2
		}else { //if it is not 1 or even...
			_count++;
			return 1 + collatz(3*n+1); //adds 1 to sum, triples number and adds 1
		}
	}
	
	/*
	 * this is the faster version of the collatz method. It calls upon a helper method, collatzFastPart(), to
	 * do all the calculations and recursion. 
	 * Parameters: Int n
	 */
	public static int collatzFast(int n) {
		_count = 1;
		return collatzFastPart(n, 1); //calls on helper method 
	}
	
	/*
	 * This is the helper method for collatzFast() that does all the calculations and recursion. It uses the
	 * same technique described in the comments for gFastPart();
	 * Parameters: int n, int sum
	 */
	public static int collatzFastPart(int n, int sum) {
		if(n==1) { //checks if n is 1
			return sum; //returns accumulated sum
		}
		while(n%2!=0) {  //if number is odd, triple it and add 1 over and over again until no longer odd
			sum++;//incerements sum
			n = 3 * n + 1;
		}
		while(n%2==0) {  //if number is even, divide by 2 until no longer possible
			sum++;  //increments sum
			n /= 2;
		}
		_count++;
		return collatzFastPart(n, sum); //recurses
	}
	
}
