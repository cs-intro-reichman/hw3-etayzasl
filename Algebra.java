// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
		// Tests some of the operations
		// tests:

		// == 275;
		int test5 = sqrt(10000);
		System.out.println("Test 5 (floor value): " + (test5));

	}

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if (x2 < 0)
			return minus(x1, -x2);
		for (int i = 0; i < x2; i++)
			x1++;
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if (x2 < 0)
			return plus(x1, -x2);
		for (int i = 0; i < x2; i++)
			x1--;
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		if (x2 < 0)
			return minus(0, times(x1, -x2));
		int addedX = 0;
		for (int i = 0; i < x2; i++)
			addedX = plus(addedX, x1);
		return addedX;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int poweredX = 1;
		for (int i = 0; i < n; i++)
			poweredX = times(poweredX, x);
		return poweredX;
	}

	// Returns the integer part of x1 / x2
	public static int div(int x1, int x2) {
		int dividedX = 0;
		boolean isNegative = false;
		if (x1 < 0) {
			x1 = times(-1, x1);
			isNegative = !isNegative;
		}
		if (x2 < 0) {
			x2 = times(-1, x2);
			isNegative = !isNegative;
		}
		while (x1 >= x2) {
			x1 = minus(x1, x2);
			dividedX++;
		}
		if (isNegative)
			dividedX = times(-1, dividedX);
		return dividedX;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int modX = 0;
		int dividedX = div(x1, x2);
		modX = minus(x1, times(dividedX, x2));
		return modX;
	}

	// Returns the integer part of sqrt(x)
	public static int sqrt(int x) {
		int sqrtX = 0;
		while (times(sqrtX + 1, sqrtX + 1) <= x) {
			sqrtX++;
		}
		return sqrtX;
	}
}